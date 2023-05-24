package pro.sky.CollectionAndSets.EmployeeData;


import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final Integer salary;
    private final Integer department;

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

    public Integer getDepartment() {
        return department;
    }

    public String getFullName(){
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + salary + " " + department;
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

