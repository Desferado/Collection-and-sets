package pro.sky.CollectionAndSets.Service;

import org.springframework.stereotype.Service;
import pro.sky.CollectionAndSets.EmployeeData.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getListEmployeeOfDepartment(Integer department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }
        if (!employeeService.getEmployeesService().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).containsKey(department)) {
            throw new NullPointerException();
        }
        return employeeService.getEmployeesService().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .toList();
    }

    @Override
    public Integer getMinSalaryEmployeeOfDepartment(Integer department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }
        if (!employeeService.getEmployeesService().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).containsKey(department)) {
            throw new NullPointerException();
        }
        return employeeService.getEmployeesService().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary)).get().getSalary();
    }
    @Override
    public Integer getSumSalaryEmployeeOfDepartment(Integer department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }
        if (!employeeService.getEmployeesService().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).containsKey(department)) {
            throw new NullPointerException();
        }
                return employeeService.getEmployeesService().values().stream()
                .filter(e1 -> e1.getDepartment().equals(department)).mapToInt(Employee::getSalary).sum();
    }
    @Override
    public Integer getMaxSalaryEmployeeOfDepartment(Integer department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }
        if (!employeeService.getEmployeesService().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).containsKey(department)) {
            throw new NullPointerException();
        }
        return employeeService.getEmployeesService().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getSalary)).get().getSalary();
    }

    public Map<Integer, List<Employee>> printListEmployeeOfDepartment() {
        return employeeService.getEmployeesService().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
