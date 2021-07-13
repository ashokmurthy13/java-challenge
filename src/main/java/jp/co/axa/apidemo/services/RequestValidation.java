package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.APIBaseException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RequestValidation {

    public void validate(EmployeeDto employeeDto) {
        if (!StringUtils.hasText(employeeDto.getName())) {
            throw new APIBaseException("employeeDto name must not be null or empty!");
        }
        if (!StringUtils.hasText(employeeDto.getDepartment())) {
            throw new APIBaseException("department name must not be null or empty!");
        }
    }
}
