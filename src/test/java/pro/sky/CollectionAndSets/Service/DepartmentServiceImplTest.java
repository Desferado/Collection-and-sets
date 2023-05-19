package pro.sky.CollectionAndSets.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CollectionAndSets.EmployeeData.Employee;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.CollectionAndSets.ServiceInplTestConstants.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl serviceMock;
@InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void sholdGetListEmployeeOfDepartment() {
        assertNotNull(serviceMock);
        Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
        List<Employee> expected = departmentService.getListEmployeeOfDepartment(CORRECT_DEPARTMENT);
        assertEquals(expected,actual);
    }
    @Test
    public void shouldGetExceptionGetListEmployeeOfDepartmentWhenDepartmentNull() {
        assertThrows(IllegalArgumentException.class, () -> departmentService.getListEmployeeOfDepartment(null));
    }
    @Test
    public void shouldGetExceptionGetListEmployeeOfDepartmentWhenNotContainsDepartment() {
        assertThrows(NullPointerException.class,
                () -> {Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
            departmentService.getListEmployeeOfDepartment(CORRECT_DEPARTMENT1);});
    }
    @Test
    void shouldGetMinSalaryEmployeeOfDepartment() {
        assertNotNull(serviceMock);
        Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
        Integer expected = departmentService.getMinSalaryEmployeeOfDepartment(CORRECT_DEPARTMENT);
        assertEquals(expected,CORRECT_SALARY);
    }
    @Test
    public void shouldGetExceptionGetMinSalaryEmployeeOfDepartmentWhenDepartmentNull() {
        assertThrows(IllegalArgumentException.class, () -> departmentService.getMinSalaryEmployeeOfDepartment(null));
    }
    @Test
    public void shouldGetExceptionGetMinSalaryEmployeeOfDepartmentWhenNotContainsDepartment() {
        assertThrows(NullPointerException.class,
                () -> {Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
                    departmentService.getMinSalaryEmployeeOfDepartment(CORRECT_DEPARTMENT1);});
    }

    @Test
    void shouldGetSumSalaryEmployeeOfDepartment() {
        assertNotNull(serviceMock);
        Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap1);
        Integer expected = departmentService.getSumSalaryEmployeeOfDepartment(CORRECT_DEPARTMENT);
        assertEquals(expected,CORRECT_SALARY1);
    }
    @Test
    public void shouldGetExceptionGetSumSalaryEmployeeOfDepartmentWhenDepartmentNull() {
        assertThrows(IllegalArgumentException.class, () -> departmentService.getSumSalaryEmployeeOfDepartment(null));
    }
    @Test
    public void shouldGetExceptionGetSumSalaryEmployeeOfDepartmentWhenNotContainsDepartment() {
        assertThrows(NullPointerException.class,
                () -> {Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
                    departmentService.getSumSalaryEmployeeOfDepartment(CORRECT_DEPARTMENT1);});
    }

    @Test
    void shouldGetMaxSalaryEmployeeOfDepartment() {
        assertNotNull(serviceMock);
        Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
        Integer expected = departmentService.getMaxSalaryEmployeeOfDepartment(CORRECT_DEPARTMENT);
        assertEquals(expected,CORRECT_SALARY);
    }
    @Test
    public void shouldGetExceptionGetMaxSalaryEmployeeOfDepartmentWhenDepartmentNull() {
        assertThrows(IllegalArgumentException.class, () -> departmentService.getMaxSalaryEmployeeOfDepartment(null));
    }
    @Test
    public void shouldGetExceptionGetMaxSalaryEmployeeOfDepartmentWhenNotContainsDepartment() {
        assertThrows(NullPointerException.class,
                () -> {Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
                    departmentService.getMaxSalaryEmployeeOfDepartment(CORRECT_DEPARTMENT1);});
    }

    @Test
    void shouldPrintListEmployeeOfDepartment() {
        assertNotNull(serviceMock);
        Mockito.when(serviceMock.getEmployeesService()).thenReturn(employeeMap);
        Map<Integer, List<Employee>> expected = departmentService.printListEmployeeOfDepartment();
        assertEquals(expected,employeeMapDept);
    }
}