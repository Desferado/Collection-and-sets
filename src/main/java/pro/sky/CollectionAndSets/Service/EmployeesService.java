package pro.sky.CollectionAndSets.Service;

import pro.sky.CollectionAndSets.EmployeeData.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface EmployeesService {

    String addEmployee(Employee employee);

    String removeEmployee(Employee employee);

    String findEmployee(Employee employee);
    Collection<Employee> findAll();


    List <Employee> getListEmployeeOfDepartment(Integer departmentEmployee);

    Employee getMinSalaryEmployeeOfDepartment(Integer departmentEmployee);

    Employee getMaxSalaryEmployeeOfDepartment(Integer departmentEmployee);

    //void printListEmployeeOfDepartment(HashMap<String, Employee> employeesService, int departmentEmployee);
}
