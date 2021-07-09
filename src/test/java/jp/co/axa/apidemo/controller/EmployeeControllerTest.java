package jp.co.axa.apidemo.controller;

import jp.co.axa.apidemo.ApiDemoApplication;
import jp.co.axa.apidemo.controllers.EmployeeController;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.APIBaseException;
import jp.co.axa.apidemo.utils.RestResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = ApiDemoApplication.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    private static final String EXPECTED_NAME = "Akira";

    @Resource
    private EmployeeController employeeController;

    @Before
    public void setup() {
        Employee employee = new Employee();
        employee.setName("Akira");
        employee.setSalary(1000000);
        employee.setDepartment("IT");
        employeeController.saveEmployee(employee);
    }

    @Test
    public void testGetEmployees() {
        RestResponse<List<Employee>> response = employeeController.getEmployees();
        Assert.assertEquals(EXPECTED_NAME, response.getResult().get(0).getName());
    }

    @Test
    public void testGetEmployee() {
        RestResponse<Employee> response = employeeController.getEmployee(1L);
        Assert.assertEquals(EXPECTED_NAME, response.getResult().getName());
    }

    @Test
    public void testAddNewEmployee() {
        Employee employee = new Employee();
        employee.setName("Toshiro");
        employee.setSalary(1000000);
        employee.setDepartment("IT");
        RestResponse<Boolean> response = employeeController.saveEmployee(employee);
        Assert.assertTrue(response.getResult());
    }

    @Test(expected = APIBaseException.class)
    public void testGetEmployeeException() {
        employeeController.getEmployee(123L);
    }

    @Test(expected = APIBaseException.class)
    public void testDeleteEmployeeException() {
        employeeController.deleteEmployee(123L);
    }

}
