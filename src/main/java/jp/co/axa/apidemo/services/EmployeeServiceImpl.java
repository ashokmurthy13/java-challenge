package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.APIBaseException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Cacheable(value = "employees", key = "'all'")
    public List<EmployeeDto> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            employeeDtoList.add(employeeDto);
        });
        return employeeDtoList;
    }

    public EmployeeDto getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        if (!optEmp.isPresent()) {
            LOG.info("no records found for the employee id: {}", employeeId);
            throw new APIBaseException("no records found for the id: " + employeeId);
        }
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(optEmp.get(), employeeDto);
        return employeeDto;
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void saveEmployee(EmployeeDto employeeDto) {
        try {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeRepository.save(employee);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new APIBaseException(e.getMessage());
        }
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new APIBaseException("employeeId:" + employeeId + " doesn't exists");
        }
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        EmployeeDto emp = getEmployee(employeeId);
        if (employeeDto.getId() != employeeId) {
            throw new APIBaseException("Employee id is an unique id and it cannot updated");
        } else if (emp != null) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeRepository.save(employee);
        }
    }
}
