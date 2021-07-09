package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Fetch all the employee details from database
     *
     * @return list of employees
     */
    List<Employee> retrieveEmployees();

    /**
     * Fetch a employee detail based on the employee id
     *
     * @param employeeId employee id
     * @return employee detail
     */
    Employee getEmployee(Long employeeId);

    /**
     * Save employee detail to the database
     *
     * @param employee employee details
     */
    void saveEmployee(Employee employee);

    /**
     * Delete a employee detail from database
     *
     * @param employeeId employee id
     */
    void deleteEmployee(Long employeeId);

    /**
     * Update the employee info such as name, department, salary based on the id
     *
     * @param employee employee details
     */
    void updateEmployee(Employee employee);
}