package com.myproject.employee.service;

import com.myproject.employee.entity.Employee;
import com.myproject.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Mono<Employee> addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .flatMap(existingEmployee -> {
                    existingEmployee.setName(updatedEmployee.getName());
                    existingEmployee.setDepartment(updatedEmployee.getDepartment());
                    existingEmployee.setSalary(updatedEmployee.getSalary());
                    return employeeRepository.save(existingEmployee);
                });
    }

    public Mono<Void> deleteEmployee(Long id) {
        return employeeRepository.deleteById(id);
    }

    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

}
