package pro.sky.CollectionAndSets.EmployeeData;

import java.util.Map;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    public Integer salary;
    public Integer department;


    public Employee(String firstName, String lastName, String middleName, Integer salary, Integer department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salary = salary;
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getMiddleName() {
        return middleName;
    }

   public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName(){
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public String toString() {
        String data = lastName + " " + firstName + " " + middleName + " " + salary + " " + department;
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName)
                && lastName.equals(employee.lastName)
                && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName);
    }

}

