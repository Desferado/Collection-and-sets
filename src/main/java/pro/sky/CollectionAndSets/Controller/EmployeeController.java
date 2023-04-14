package pro.sky.CollectionAndSets.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Service.EmployeesService;

import java.util.Collection;
import java.util.HashMap;

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
    @GetMapping("/departments/all")
    public String getListEmployeeOfDepartment(@RequestParam("department") Integer department) {
       return employees.getListEmployeeOfDepartment(department).toString();
    }
    @GetMapping("/departments/min-salary")
    public String getMinSalaryEmployeeOfDepartment(@RequestParam("department") Integer department) {
        return employees.getMinSalaryEmployeeOfDepartment(department).toString();
    }
    @GetMapping("/departments/departments/max-salary")
    public String getMaxSalaryEmployeeOfDepartment(@RequestParam("department") Integer department) {
        return employees.getMaxSalaryEmployeeOfDepartment(department).toString();
    }
    @GetMapping("/departments/allEmployee")
    public String printListEmployeeOfDepartment() {
        return employees.printListEmployeeOfDepartment().toString();
    }
}
