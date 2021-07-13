package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.dto.EmployeeDto;
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
    public RestResponse<List<EmployeeDto>> getEmployees() {
        return new RestResponse<>(employeeService.retrieveEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    public RestResponse<EmployeeDto> getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        return new RestResponse<>(employeeService.getEmployee(employeeId));
    }

    @PostMapping("/employees")
    public RestResponse<Boolean> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        validation.validate(employeeDto);
        employeeService.saveEmployee(employeeDto);
        return new RestResponse<>(true);
    }

    @DeleteMapping("/employees/{employeeId}")
    public RestResponse<Boolean> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new RestResponse<>(true);
    }

    @PutMapping("/employees/{employeeId}")
    public RestResponse<Boolean> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                                @PathVariable(name = "employeeId") Long employeeId) {
        employeeService.updateEmployee(employeeDto, employeeId);
        return new RestResponse<>(true);
    }
}
