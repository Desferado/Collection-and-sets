package pro.sky.CollectionAndSets.Service;

import pro.sky.CollectionAndSets.EmployeeData.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> getListEmployeeOfDepartment(Integer department);

    Integer getMinSalaryEmployeeOfDepartment(Integer department);

    Integer getMaxSalaryEmployeeOfDepartment(Integer department);

    Integer getSumSalaryEmployeeOfDepartment(Integer department);
    Map<Integer, List<Employee>> printListEmployeeOfDepartment();
}

