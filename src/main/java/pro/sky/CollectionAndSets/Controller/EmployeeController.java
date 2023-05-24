package pro.sky.CollectionAndSets.Controller;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Service.EmployeesService;

import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
       private final EmployeesService employees;


    public EmployeeController(EmployeesService employees) {

        this.employees = employees;
    }

    @GetMapping("/add")
    public String addEmployee(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("middleName") String middleName,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department) {
        Employee employee = new Employee(name, lastName, middleName, salary, department);
        return employees.addEmployee(employee);
    }
    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("name") String name,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("middleName") String middleName,
                                 @RequestParam("salary") Integer salary,
                                 @RequestParam("department") Integer department) {
        Employee employee = new Employee(name, lastName, middleName, salary, department);
        return employees.removeEmployee(employee);
    }
    @GetMapping("/find")
    public String findEmployee(@RequestParam("name") String name,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("middleName") String middleName,
                               @RequestParam("salary") Integer salary,
                               @RequestParam("department") Integer department) {
        Employee employee = new Employee(name, lastName, middleName, salary, department);
        return employees.findEmployee(employee);
    }


   @GetMapping
    public Collection<Employee> findAll(){
        return employees.findAll();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return name + " parameter is missing";

    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMissingParams(MethodArgumentTypeMismatchException ex) {
        String name = ex.getName();
        return name + " parameter is not String";
    }
}
