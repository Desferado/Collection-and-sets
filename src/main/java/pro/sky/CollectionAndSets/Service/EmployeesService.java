package pro.sky.CollectionAndSets.Service;

import pro.sky.CollectionAndSets.EmployeeData.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeesService {

    String addEmployee(Employee employee);

    String removeEmployee(Employee employee);

    String findEmployee(Employee employee);
    Collection<Employee> findAll();


    List <Employee> getListEmployeeOfDepartment(Integer departmentEmployee);

    Optional<Employee> getMinSalaryEmployeeOfDepartment(Integer departmentEmployee);

    Optional<Employee> getMaxSalaryEmployeeOfDepartment(Integer departmentEmployee);

    //void printListEmployeeOfDepartment(HashMap<String, Employee> employeesService, int departmentEmployee);
}
