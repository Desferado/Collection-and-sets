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

    @GetMapping("/{dept}/employees")
    public String getListEmployeeOfDepartment(@RequestParam("department") Integer department, @PathVariable String dept) {
        return this.department.getListEmployeeOfDepartment(department).toString();
    }
    @GetMapping("/{dept}/salary/min")
    public String getMinSalaryEmployeeOfDepartment(@RequestParam("department") Integer department, @PathVariable String dept) {
        return "Min salary in department" + this.department.getMinSalaryEmployeeOfDepartment(department);
    }
    @GetMapping("/{dept}/salary/max")
    public String getMaxSalaryEmployeeOfDepartment(@RequestParam("department") Integer department, @PathVariable String dept) {
        return "Max salary in department" + this.department.getMaxSalaryEmployeeOfDepartment(department);
    }
    @GetMapping("/{dept}/salary/sum")
    public String getSumSalaryEmployeeOfDepartment(@RequestParam("department") Integer department, @PathVariable String dept) {
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
