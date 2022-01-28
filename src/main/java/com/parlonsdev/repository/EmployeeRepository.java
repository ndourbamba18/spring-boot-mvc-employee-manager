package com.parlonsdev.repository;

import com.parlonsdev.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByName(String name);
    Optional<Employee> findByPhoneNumber(String phoneNumber);

    boolean existsByName(String name);
    boolean existsByPhoneNumber(String phoneNumber);
}
