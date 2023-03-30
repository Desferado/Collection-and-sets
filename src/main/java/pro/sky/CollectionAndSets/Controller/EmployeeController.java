package pro.sky.CollectionAndSets.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Service.EmployeesService;

import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
       private EmployeesService employees;

    public EmployeeController(EmployeesService employees) {

        this.employees = employees;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        return employees.addEmployee(employee);
    }
    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        return employees.removeEmployee(employee);
    }
    @GetMapping("/find")
    public String findEmployee(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(name, lastName);
        return employees.findEmployee(employee);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return employees.findAll();
    }

}
