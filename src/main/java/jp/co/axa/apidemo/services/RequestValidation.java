package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.APIBaseException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RequestValidation {

    public void validate(Employee employee) {
        if (!StringUtils.hasText(employee.getName())) {
            throw new APIBaseException("employee name must not be null or empty!");
        }
        if (!StringUtils.hasText(employee.getDepartment())) {
            throw new APIBaseException("department name must not be null or empty!");
        }
    }
}
