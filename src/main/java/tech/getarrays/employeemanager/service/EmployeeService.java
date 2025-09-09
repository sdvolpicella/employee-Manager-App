package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        Long lastCode = employeeRepo.findMaxEmployeeCode();
        Long nextCode = (lastCode != null) ? lastCode + 1 : 1;

        employee.setEmployeeCode(nextCode);
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){

        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){

        Employee existing = employeeRepo.findById(employee.getId())
                .orElseThrow(() -> new UserNotFoundException("User by id " + employee.getId() + " was not found"));

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setJobTitle(employee.getJobTitle());
        existing.setPhone(employee.getPhone());
        existing.setImageUrl(employee.getImageUrl());
        return employeeRepo.save(existing);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new UserNotFoundException("User by id " + id + " was not found");
        }

        employeeRepo.deleteEmployeeById(id);
    }

    @Transactional
    public void deleteAllEmployees(){
        employeeRepo.deleteAll();
    }



}
