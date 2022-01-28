package com.parlonsdev.controller;

import com.parlonsdev.dto.EmployeeDto;
import com.parlonsdev.model.Contact;
import com.parlonsdev.model.Employee;
import com.parlonsdev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/")
    public String index(){

        return "home";
    }

    @GetMapping(path = "/home")
    public String home(){

        return "home";
    }

    @GetMapping(path = "/about")
    public String aboutUs(){

        return "about";
    }

    @GetMapping(path = "/contact")
    public String contactUsForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    // GET ALL EMPLOYEES FROM DATABASE
    @GetMapping(path = "/employees-list")
    public String getAllEmployees(@NotNull Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/list_employee";
    }

    @GetMapping(path = "/employee-form")
    public String employeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employees/employee_form";
    }

    // SAVE EMPLOYEE FROM DATABASE
    @PostMapping(path = "/save-employee")
    public String saveEmployee(Model model, @Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                               BindingResult bindingResult){
       try {
           if (bindingResult.hasErrors())
               return "employee_form";
           /*if(employeeService.existsByName(employeeDto.getName()))
               return "employees/employee_form";
           if (employeeService.existsByPhoneNumber(employeeDto.getPhoneNumber()))
               return "employees/employee_form";
           if (employeeDto.getName()=="" || employeeDto.getEmail()=="" || employeeDto.getPhoneNumber()=="" || employeeDto.getAddress()=="")
               return "employees/employee_form";*/

           Employee employee = new Employee(employeeDto.getName(), employeeDto.getEmail(),
                   employeeDto.getPhoneNumber(), employeeDto.getAddress());
           model.addAttribute("employee", employee);
           employeeService.saveEmployee(employee);
           return "employees/employee_success";
       }catch (Exception e){
           return "employees/employee_form";
       }
    }

    @GetMapping(path = "/employee-success")
    public String employeeSuccess(Model model, @ModelAttribute("employee") Employee employee){
        model.addAttribute("employee", employee);
        return "employees/employee_success";
    }

    // DELETE EMPLOYEE BY ID
    @GetMapping(path = "/delete-employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employees-list";
    }

    // UPDATE EMPLOYEE FORM BY ID
    @GetMapping(path = "/edit-employee-form/{id}")
    public String updateEmployeeByIdForm(Model model, @PathVariable("id") Long id){
        Employee employee = employeeService.getOne(id).get();
        model.addAttribute("employee", employee);
        return "employees/update_employee";
    }

    // UPDATE EMPLOYEE BY ID
    @PostMapping(path = "/edit-employee/{id}")
    public String updateEmployeeById(@PathVariable("id") Long id, Model model,
                                     @Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto){

        Employee employee = employeeService.getOne(id).get();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());
        employeeService.saveEmployee(employee);
        return "redirect:/employees-list";
    }

    // GET A SINGLE EMPLOYEE BY ID
    @GetMapping(path = "/detail-employee/{id}")
    public String getEmployeeById(@PathVariable("id") Long id, Model model){
        Employee employee = employeeService.getOne(id).get();
        model.addAttribute("employee", employee);
        return "employees/detail_employee";
    }
}
