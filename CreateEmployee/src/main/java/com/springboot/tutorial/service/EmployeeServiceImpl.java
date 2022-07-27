package com.springboot.tutorial.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.apache.catalina.connector.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.tutorial.entity.Employee;
import com.springboot.tutorial.repository.EmployeeRepository;

import javassist.tools.web.BadHttpRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final String BAD_REQUEST = null;
	@Autowired
    private EmployeeRepository emprepo;

	@Override
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	 

	@Override
	public Employee saveEmployee(Employee emp) {
 		return emprepo.save(emp);
	}
	@Override
	public String deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp=emprepo.findById(id);
		if(emp.isPresent()) {
		emprepo.delete(emp.get());
		return "Employee deleted sucessfully";
		}
		return "Employee Doesn't exist";
	}


	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> employee=emprepo.findById(emp.getId());
		if(employee.isEmpty()) {
			throw new IllegalArgumentException("Invalid employee Id");
		}
		System.out.println("EMP "+employee.get().getId());
 		return   emprepo.save(emp);
	}
	@Override
	public void importToDb(List<MultipartFile> multipartfiles) {
		if (!multipartfiles.isEmpty()) {
			List<Employee> employees = new ArrayList<>();
			multipartfiles.forEach(multipartfile -> {
				try {
					XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

					XSSFSheet sheet = workBook.getSheetAt(0);
					// looping through each row
					for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) - 1; rowIndex++) {
						// current row
						XSSFRow row = sheet.getRow(rowIndex);
						// skip the first row because it is a header row
						if (rowIndex == 0) {
							continue;
						}
						int id = Integer.parseInt(row.getCell(0).toString());
						String name = String.valueOf(row.getCell(1));
						int joiningDate = Integer.parseInt(row.getCell(2).toString());
						int birthDate = Integer.parseInt(row.getCell(3).toString());
						float salary = Float.parseFloat(row.getCell(4).toString());
						
						Employee employee = Employee.builder().setId(id).name(name)
								.joiningDate(joiningDate).birthDate(birthDate).salary(salary)build());
			              employees.add(employee);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			if (!employees.isEmpty()) {
				// save to database
				emprepo.saveAll(employees);
			}
		}
	}

	private float build() {
		// TODO Auto-generated method stub
		return 0;
	}



	private Object getValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue());
		case BOOLEAN:
			return cell.getBooleanCellValue();
		case ERROR:
			return cell.getErrorCellValue();
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return null;
		case _NONE:
			return null;
		default:
			break;
		}
		return null;
	}

	public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
		int numOfNonEmptyCells = 0;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				XSSFCell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() != CellType.BLANK) {
					numOfNonEmptyCells++;
				}
			}
		}
		return numOfNonEmptyCells;
	}
}



