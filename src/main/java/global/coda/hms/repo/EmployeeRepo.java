package global.coda.hms.repo;

import global.coda.hms.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
  Employee findAllByFirstName(String name);

}
