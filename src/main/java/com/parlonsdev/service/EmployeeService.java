package com.parlonsdev.service;

import com.parlonsdev.model.Employee;
import com.parlonsdev.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> getOne(Long id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(Long id){
        this.employeeRepository.deleteById(id);
    }

    public void deleteAllEmployees(){
        this.employeeRepository.deleteAll();
    }

    public boolean existsByName(String name){

        return employeeRepository.existsByName(name);
    }

    public boolean existsByPhoneNumber(String phoneNumber){
        return employeeRepository.existsByPhoneNumber(phoneNumber);
    }
}
