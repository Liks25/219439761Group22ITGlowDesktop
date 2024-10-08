package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost/3004")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/read/{employeeID}")
    public Employee read(@PathVariable String employeeID) {
        return employeeService.read(employeeID);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }

    @GetMapping("/getall")
    public List<Employee> getall() {
        return employeeService.getall();
    }

    @PostMapping("/login")
    public Employee login(@RequestBody Employee request) {
        Employee response = employeeService.login(request);
        if (response.isSuccess()) {
            return new Employee(true, "login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response).getBody();
        }
    }
}



