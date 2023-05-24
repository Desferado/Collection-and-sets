package pro.sky.CollectionAndSets.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.CollectionAndSets.Exceptions.CollectionIsEmtyExeption;

import static pro.sky.CollectionAndSets.ServiceInplTestConstants.*;

class EmployeeServiceImplTest {
    public EmployeesService employeesService = new EmployeeServiceImpl();

    @Test
    void shouldReturnCorrectAddEmployeeWhenFullNameCorrect() {
        String result = employeesService.addEmployee(employee1);
        Assertions.assertEquals(actual.toString(), result);
    }
    @Test
    void shouldReturnMessageAddEmployeeWhenFullNameNotCorrect() {
        String result = employeesService.addEmployee(employee2);
        Assertions.assertEquals("Name contains illegal characters", result);
    }
    @Test
    void shouldReturnMessageAddEmployeeWhenCollectionContainEmployee() {
        employeesService.addEmployee(employee);
        String result = employeesService.addEmployee(employee);
        Assertions.assertEquals("This employee already added in the list", result);
    }

    @Test
    void shouldReturnCorrectRemoveEmployeeWhenFullNameCorrect() {
        employeesService.addEmployee(employee1);
        employeesService.addEmployee(employee);
        String result = employeesService.removeEmployee(employee);
        Assertions.assertEquals(actual.toString(), result);
    }
    @Test
    void shouldReturnMessageRemoveEmployeeWhenCollectionNotContainEmployee() {
        String result = employeesService.removeEmployee(employee);
        Assertions.assertEquals("This employee wasn't found in the list", result);
    }
    @Test
    void shouldReturnFindEmployeeWhenCollectionContainEmployee() {
        employeesService.addEmployee(employee);
        String result = employeesService.findEmployee(employee);
        Assertions.assertEquals("This employee was found in the list:  " + fullName, result);
    }
    @Test
    void shouldReturnMessageFindEmployeeWhenCollectionNotContainEmployee() {
        String result = employeesService.findEmployee(employee);
        Assertions.assertEquals("This employee wasn't found in the list", result);
    }
    @Test
    void shouldReturnMessageFindAllWhenFullNameNotCorrect() {
        String result = employeesService.findEmployee(employee2);
        Assertions.assertEquals("Name contains illegal characters", result);
    }
    @Test
    void shouldReturnExceptionFindEmployeeWhenFullNameNotCorrect() {
        Assertions.assertThrows(CollectionIsEmtyExeption.class, ()-> employeesService.findAll());
    }
}