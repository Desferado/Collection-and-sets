package pro.sky.CollectionAndSets.Service;

import org.springframework.stereotype.Service;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Exceptions.EmployeeNotFoundException;
import pro.sky.CollectionAndSets.Exceptions.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeesService {
    Map <String,Employee> employeesService = new HashMap<>(Map.of(
        "Ivanov Ivan Ivanovich", new Employee("Ivan", "Ivanov", "Ivanovich", 25000, 1),
        "Petrov Petr Petrovich", new Employee("Petr", "Petrov", "Petrovich", 30000, 2),
        "Safin Timur Germanovich", new Employee("Timur", "Safin", "Germanovich", 35000, 3),
        "Stepanov Stepan Stepanovich", new Employee("Stepan", "Stepanov", "Stepanovich", 40000, 4),
            "Trusov Dmitriy Ivanovich", new Employee("Dmitriy", "Trusov", "Ivanovich", 45000, 1),
            "Rudov Vladimir Maximovich", new Employee("Vladimir", "Rudov", "Maximovich", 50000, 2),
            "Kruglov Maxim Dmitrievich", new Employee("Maxim", "Kruglov", "Dmitrievich", 55000, 3),
            "Putin Vladimir Vladimirovich", new Employee("Vladimir", "Putin", "Vladimirovich", 60000, 4)
    ));
@Override
    public String addEmployee(Employee employee) {
    try {
        if (employeesService.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
    }
    catch (EmployeeAlreadyAddedException employeeAlreadyAddedException){
        return "This employee already added in the list";
    }
    employeesService.put(employee.getFullName(), employee);
    return employeesService.toString();
    }
    @Override
    public String removeEmployee(Employee employee) {
        try {
            if (!employeesService.containsKey(employee.getFullName())) {
                throw new EmployeeNotFoundException();
            }
        }
        catch (EmployeeNotFoundException employeeNotFoundException){
            return "This employee wasn't found in the list";
        }
        employeesService.remove(employee.getFullName());
        return employeesService.toString();
    }
    @Override
    public String findEmployee(Employee employee) {
        try {
            if (!employeesService.containsKey(employee.getFullName())) {
                throw new EmployeeNotFoundException("No matches");
            }
        }
        catch (EmployeeNotFoundException employeeNotFoundException){
            return "This employee wasn't found in the list";
        }

        return "This employee was found in the list";
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeesService.values());
    }

    @Override
    public List<Employee> getListEmployeeOfDepartment(Integer departmentEmployee) {
        return employeesService.values().stream()
                .filter(e -> e.getDepartment().equals(departmentEmployee))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Employee> getMinSalaryEmployeeOfDepartment(Integer departmentEmployee) {
        Optional <Employee> minSalary = employeesService.values().stream()
                .filter(e -> e.getDepartment().equals(departmentEmployee))
                .min(Comparator.comparingInt(Employee::getSalary));
        return minSalary;
    }
    @Override
    public Optional<Employee> getMaxSalaryEmployeeOfDepartment(Integer departmentEmployee) {
        Optional <Employee> maxSalary = employeesService.values().stream()
                .filter(e -> e.getDepartment().equals(departmentEmployee))
                .max(Comparator.comparingInt(Employee::getSalary));
        return maxSalary;
    }


}
