package pro.sky.CollectionAndSets.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Exceptions.*;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeesService {
   public  Employee employee;
   private final Map<String, Employee> employeesService;

    public EmployeeServiceImpl() {
        this.employeesService = new HashMap<>(Map.of());
    }

    public Map<String, Employee> getEmployeesService() {
        return employeesService;
    }

    @Override
    public String toString() {
        return employee.getFullName() + " " + employee.getSalary() + " " + employee.getDepartment();
    }


/*   Map<String, Employee> employeesService = new HashMap<>(Map.of(
            "Ivanov Ivan Ivanovich", new Employee("Ivan", "Ivanov", "Ivanovich", 25000, 1),
            "Petrov Petr Petrovich", new Employee("Petr", "Petrov", "Petrovich", 30000, 2),
            "Safin Timur Germanovich", new Employee("Timur", "Safin", "Germanovich", 35000, 3),
            "Stepanov Stepan Stepanovich", new Employee("Stepan", "Stepanov", "Stepanovich", 40000, 4),
            "Trusov Dmitriy Ivanovich", new Employee("Dmitriy", "Trusov", "Ivanovich", 45000, 1),
            "Rudov Vladimir Maximovich", new Employee("Vladimir", "Rudov", "Maximovich", 50000, 2),
            "Kruglov Maxim Dmitrievich", new Employee("Maxim", "Kruglov", "Dmitrievich", 55000, 3),
            "Putin Vladimir Vladimirovich", new Employee("Vladimir", "Putin", "Vladimirovich", 60000, 4)
    ));*/


    @Override
    public String addEmployee(Employee employee) {
        try {
            if (employeesService.containsKey(employee.getFullName())) {throw new EmployeeAlreadyAddedException();}
        } catch (EmployeeAlreadyAddedException employeeAlreadyAddedException) { return "This employee already added in the list";}
        try{
            if (StringUtils.containsAny(employee.getFullName(), "0123456789-+!?/,.@#$%^&*_~")) {
                throw new NameContainsIllegalCharacterException();}
        } catch (NameContainsIllegalCharacterException ex) { return "Name contains illegal characters";}
        employeesService.put(employee.getFullName(),employee);
        return employeesService.values().toString();
    }

    @Override
    public String removeEmployee(Employee employee) {
        try {
            if (!employeesService.containsKey(employee.getFullName())) {
                throw new EmployeeNotFoundException();
            }
        } catch (EmployeeNotFoundException employeeNotFoundException) {
            return "This employee wasn't found in the list";
        }
        employeesService.remove(employee.getFullName());
        return employeesService.toString();
    }

    @Override
    public String findEmployee(Employee employee) {
        try{
            if (StringUtils.containsAny(employee.getFullName(), "0123456789-+!?/,.@#$%^&*_~")) {
                throw new NameContainsIllegalCharacterException();}
        } catch (NameContainsIllegalCharacterException ex) {
            return "Name contains illegal characters";}
        try {if (!employeesService.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("No matches");
        }
        } catch (EmployeeNotFoundException employeeNotFoundException) {
            return "This employee wasn't found in the list";
        }
        return "This employee was found in the list:  " + employee.getFullName();
    }

    @Override
    public Collection<Employee> findAll() {
        if (employeesService.isEmpty()) {
            throw new CollectionIsEmtyExeption();
        }
        return Collections.unmodifiableCollection(employeesService.values());
    }

    /*@Override
    public Function<List<Employee>, Integer> getFunction(List<Employee> employeesService, Integer department) {
        // Collections.frequency(names, name) => to get duplicate count

        return employee -> {
            return Integer.valueOf(employee + " (" + Collections.frequency(employeesService, department) + ")")
                    :Function.identity();
        };
    }*/
}
