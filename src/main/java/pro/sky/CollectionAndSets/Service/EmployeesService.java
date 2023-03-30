package pro.sky.CollectionAndSets.Service;

import pro.sky.CollectionAndSets.EmployeeData.Employee;

import java.util.Collection;

public interface EmployeesService {
    String addEmployee(Employee employee);

    String removeEmployee(Employee employee);

    String findEmployee(Employee employee);
    Collection<Employee> findAll();
}
