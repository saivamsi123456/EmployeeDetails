package com.springboot.tutorial.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.tutorial.entity.Employee;
import com.springboot.tutorial.service.EmployeeService;
import com.springboot.tutorial.service.EmployeeServiceImpl;

@RestController 
public class EmployeeController {

	@Autowired
	private EmployeeService service; 
	
	@RequestMapping(value = "/createEmp",method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return service.saveEmployee(employee);
	}
	
	@RequestMapping(value = "/updateEmp",method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		 
		return service.updateEmployee(employee);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteEmployee(@RequestParam Integer empId) {
		
		return service.deleteEmployee(empId);
	}

	@GetMapping("getAllEmp")
	public List<Employee> getEmployees() {
		
		return service.listAll();
	}
    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;
    

	@PostMapping("/uploadFile")
	public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException{
		File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos =new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
	}

	@RequestMapping(path = "/employees")
	@PostMapping(path = "/import-to-db")
		public void importTransactionsFromExcelToDb(@RequestPart(required = true) List<MultipartFile> files) {

		service.importToDb(files);
	}	
		
}


