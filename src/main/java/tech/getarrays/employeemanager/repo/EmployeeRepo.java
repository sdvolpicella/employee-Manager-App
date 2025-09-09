package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    @Query("SELECT MAX(e.employeeCode) FROM Employee e")
    Long findMaxEmployeeCode();
}
