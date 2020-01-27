package global.coda.hms.controller;

import global.coda.hms.model.Employee;
import global.coda.hms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;
  @PostMapping("/add")
  public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
    Employee createdEmployee = employeeService.createEmployee(employee);
    return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
  }
}
