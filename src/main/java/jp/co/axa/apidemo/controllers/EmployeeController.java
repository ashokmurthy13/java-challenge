package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.services.RequestValidation;
import jp.co.axa.apidemo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RequestValidation validation;

    public void setEmployeeService(EmployeeService employeeService, RequestValidation validation) {
        this.employeeService = employeeService;
        this.validation = validation;
    }

    @GetMapping("/employees")
    public RestResponse<List<Employee>> getEmployees() {
        return new RestResponse<>(employeeService.retrieveEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    public RestResponse<Employee> getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        return new RestResponse<>(employeeService.getEmployee(employeeId));
    }

    @PostMapping("/employees")
    public RestResponse<Boolean> saveEmployee(@RequestBody Employee employee) {
        validation.validate(employee);
        employeeService.saveEmployee(employee);
        return new RestResponse<>(true);
    }

    @DeleteMapping("/employees/{employeeId}")
    public RestResponse<Boolean> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new RestResponse<>(true);
    }

    @PutMapping("/employees/{employeeId}")
    public RestResponse<Boolean> updateEmployee(@RequestBody Employee employee,
                                                @PathVariable(name = "employeeId") Long employeeId) {
        Employee emp = employeeService.getEmployee(employeeId);
        if (emp != null) {
            employeeService.updateEmployee(employee);
        }
        return new RestResponse<>(true);
    }
}
