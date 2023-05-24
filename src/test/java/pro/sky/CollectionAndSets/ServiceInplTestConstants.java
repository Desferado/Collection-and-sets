package pro.sky.CollectionAndSets;

import pro.sky.CollectionAndSets.EmployeeData.Employee;

import java.util.*;

public class ServiceInplTestConstants {
    public static final String CORRECT_FIRST_NAME = "Ivan";
    public static final String CORRECT_FIRST_NAME1 = "Petr";
    public static final String CORRECT_LAST_NAME = "Ivanov";
    public static final String CORRECT_LAST_NAME1 = "Petrov";
    public static final String ILLEGAL_FIRST_NAME = "Iva52n";
    public static final String CORRECT_MIDDLENAME = "Ivanovich";
    public static final String CORRECT_MIDDLENAME1 = "Petrovich";
    public static final Integer CORRECT_DEPARTMENT = 52;
    public static final Integer CORRECT_DEPARTMENT1 = 23;
    public static final Integer CORRECT_SALARY = 120000;
    public static final Integer CORRECT_SALARY1 = 240000;
    public static String fullName = CORRECT_LAST_NAME + " " + CORRECT_FIRST_NAME + " " + CORRECT_MIDDLENAME;
    public static String fullName1 = CORRECT_LAST_NAME1 + " " + CORRECT_FIRST_NAME1 + " " + CORRECT_MIDDLENAME1;

    public static Employee employee = new Employee(
            CORRECT_FIRST_NAME,
            CORRECT_LAST_NAME,
            CORRECT_MIDDLENAME,
            CORRECT_SALARY,
            CORRECT_DEPARTMENT);
    public static Employee employee1 = new Employee(
            CORRECT_FIRST_NAME1,
            CORRECT_LAST_NAME1,
            CORRECT_MIDDLENAME1,
            CORRECT_SALARY,
            CORRECT_DEPARTMENT);
    public static Employee employee2 = new Employee(
            ILLEGAL_FIRST_NAME,
            CORRECT_LAST_NAME,
            CORRECT_MIDDLENAME1,
            CORRECT_SALARY,
            CORRECT_DEPARTMENT);
    public static final Map<String,Employee> employeeMap = new HashMap<>(Map.of(fullName, employee));
    public static final List<Employee> actual = new ArrayList<>(List.of(employee));
    public static final Map<Integer,List<Employee>> employeeMapDept = new HashMap<>(Map.of(CORRECT_DEPARTMENT, actual));
    public static final Map<String,Employee> employeeMap1 = new HashMap<>(Map.of(fullName, employee, fullName1, employee1));

}
