package pro.sky.CollectionAndSets.Controller;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Service.DepartmentServiceImpl;
import java.util.List;
import java.util.Map;

@RequestMapping("/department")
@RestController

public class DepartmentController {
    private final DepartmentServiceImpl department;


    public DepartmentController(DepartmentServiceImpl department) {

        this.department = department;
    }

    @GetMapping("/{id}/employees")
    public String getListEmployeeOfDepartment(@PathVariable ("id") Integer department) {
        return this.department.getListEmployeeOfDepartment(department).toString();
    }
    @GetMapping("/{id}/salary/min")
    public String getMinSalaryEmployeeOfDepartment(@PathVariable ("id") Integer department) {
        return "Min salary in department" + this.department.getMinSalaryEmployeeOfDepartment(department);
    }
    @GetMapping("/{id}/salary/max")
    public String getMaxSalaryEmployeeOfDepartment(@PathVariable ("id") Integer department) {
        return "Max salary in department" + this.department.getMaxSalaryEmployeeOfDepartment(department);
    }
    @GetMapping("/{id}/salary/sum")
    public String getSumSalaryEmployeeOfDepartment(@PathVariable ("id") Integer department) {
        return this.department.getSumSalaryEmployeeOfDepartment(department).toString();
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> printListEmployeeOfDepartment() {
        return department.printListEmployeeOfDepartment();
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return name + " parameter is missing";

    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMissingParams(MethodArgumentTypeMismatchException ex) {
        String name = ex.getName();
        return name + " parameter is not Integer";
    }
}
