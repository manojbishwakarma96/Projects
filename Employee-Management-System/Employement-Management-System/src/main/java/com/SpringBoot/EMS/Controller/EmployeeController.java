package com.SpringBoot.EMS.Controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot.EMS.Service.EmployeeService;
import com.SpringBoot.EMS.dto.EmployeeDto;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

  private EmployeeService employeService;
  
  
  public EmployeeController(EmployeeService employeService) {
	super();
	this.employeService = employeService;
   }




@PostMapping()
  public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
	 EmployeeDto savedEmployee=employeService.createEmployee(employeeDto);
	  return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	  
  }
  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDto> getemployeeById(@PathVariable(name="id") Long employeeId){
	  EmployeeDto employeeDto= employeService.getEmployeeByID(employeeId);
	  return ResponseEntity.ok(employeeDto);
	  
  }
  @GetMapping()
  public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
	  List<EmployeeDto> employeeDto= employeService.getAllEmployee();
	  return ResponseEntity.ok(employeeDto);
  }
  @PutMapping("/{id}")
  public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable(name = "id") Long id){
	  EmployeeDto updateEmployeeDto=employeService.updateEmployee(employeeDto, id);
	  return new ResponseEntity<>(updateEmployeeDto,HttpStatus.OK);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long id) { 
	  employeService.deleteEmployee(id);
	  return new ResponseEntity<>("Employee Deleted by id sucessfully",HttpStatus.OK);
  }
  
}
