package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.APIBaseException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        if (!optEmp.isPresent()) {
            LOG.info("no records found for the employee id: {}", employeeId);
            throw new APIBaseException("no records found for the id: " + employeeId);
        }
        return optEmp.get();
    }

    public void saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new APIBaseException(e.getMessage());
        }
    }

    public void deleteEmployee(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new APIBaseException("employeeId:" + employeeId + " doesn't exists");
        }
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
