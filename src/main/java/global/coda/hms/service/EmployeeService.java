package global.coda.hms.service;

import global.coda.hms.model.Employee;
import global.coda.hms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  @Autowired
  EmployeeRepo repo;
  public Employee createEmployee(Employee employee) {

    return repo.save(employee);
  }
}
