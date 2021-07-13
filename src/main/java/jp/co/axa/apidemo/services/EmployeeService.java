package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Fetch all the employee details from database
     *
     * @return list of employees
     */
    List<EmployeeDto> retrieveEmployees();

    /**
     * Fetch a employee detail based on the employee id
     *
     * @param employeeId employee id
     * @return employeeDto detail
     */
    EmployeeDto getEmployee(Long employeeId);

    /**
     * Save employeeDto detail to the database
     *
     * @param employeeDto employeeDto details
     */
    void saveEmployee(EmployeeDto employeeDto);

    /**
     * Delete a employee detail from database
     *
     * @param employeeId employee id
     */
    void deleteEmployee(Long employeeId);

    /**
     * Update the employeeDto info such as name, department, salary based on the id
     *
     * @param employeeDto employeeDto details
     */
    void updateEmployee(EmployeeDto employeeDto, Long employeeId);
}