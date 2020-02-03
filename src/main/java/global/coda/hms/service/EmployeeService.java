package global.coda.hms.service;

import global.coda.hms.model.Employee;
import global.coda.hms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Employee service.
 */
@Service
public class EmployeeService {
  /**
   * The Repo.
   */
  @Autowired
  EmployeeRepo repo;

  /**
   * Create employee employee.
   *
   * @param employee the employee
   * @return the employee
   */
  public Employee createEmployee(Employee employee) {

    return repo.save(employee);
  }
}
