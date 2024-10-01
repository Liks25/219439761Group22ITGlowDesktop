package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3004")
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){return employeeService.create(employee);}
    @GetMapping("/read/{idNumber}")
    public Employee read(@PathVariable Long idNumber){return employeeService.read(idNumber);}
    @PostMapping("/update")
    public Employee update (@RequestBody Employee employee){return employeeService.update(employee);}
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){employeeService.delete(id);}
    @GetMapping("/getall")
    public List<Employee> getall(){return employeeService.getall();}
}
