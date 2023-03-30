package pro.sky.CollectionAndSets.Service;

import org.springframework.stereotype.Service;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import pro.sky.CollectionAndSets.Exceptions.EmployeeNotFoundException;
import pro.sky.CollectionAndSets.Exceptions.EmployeeAlreadyAddedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeService implements EmployeesService {


    private final List<Employee> employeesService;

    public EmployeeService(List<Employee> employeesService) {
        this.employeesService = employeesService;
    }

    public static void employeeService() {
        List <Employee> employeesService = new ArrayList<Employee>();
    }
@Override
    public String addEmployee(Employee employee) {
    try {
        if (employeesService.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
    }
    catch (EmployeeAlreadyAddedException employeeAlreadyAddedException){
        return "This employee already added in the list";
    }
    employeesService.add(employee);
    return employeesService.toString();
    }
    @Override
    public String removeEmployee(Employee employee) {
        try {
            if (!employeesService.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
        }
        catch (EmployeeNotFoundException employeeNotFoundException){
            return "This employee wasn't found in the list";
        }
        employeesService.remove(employee);
        return employeesService.toString();
    }
    @Override
    public String findEmployee(Employee employee) {
        try {
            if (!employeesService.contains(employee)) {
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
        return Collections.unmodifiableList(employeesService);
    }


}
