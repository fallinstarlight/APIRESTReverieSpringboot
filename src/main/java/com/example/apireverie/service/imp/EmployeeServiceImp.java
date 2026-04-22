package com.example.apireverie.service.imp;

import com.example.apireverie.entity.Employee;
import com.example.apireverie.model.request.EmployeeRequest;
import com.example.apireverie.model.response.EmployeeResponse;
import com.example.apireverie.repository.IEmployeeRepository;
import com.example.apireverie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /* ---- Método del compañero (GET) ---- */
    @Override
    public List<EmployeeResponse> getEmployees() {
        List<EmployeeResponse> response = new ArrayList<>();

        /**
         * Filters only active employees (state = 'alive').
         * @author Luis Fernando Tolentino Segovia
         */
        List<Employee> employees = iEmployeeRepository.findActiveEmployees();

        for (Employee e : employees) {
            EmployeeResponse er = new EmployeeResponse();
            er.setID(e.getId());
            er.setName(e.getName());
            er.setTotalSales(e.getTotalSales());
            er.setTodaySales(e.getTodaySales());
            er.setRole(e.getRole());
            er.setShift(e.getShift());
            er.setPhoto(e.getProfilePhoto());
            response.add(er);
        }
        return response;
    }

    /**
     * Calls the stored procedure inEmployee to insert a new employee.
     * @author Luis Fernando Tolentino Segovia
     */
    @Override
    public void createEmployee(EmployeeRequest request) {
        iEmployeeRepository.insertEmployee(
                request.getName(),
                request.getSurname(),
                request.getUsername(),
                request.getPasswordHash(),
                request.getShift(),
                request.getPhone(),
                request.getPhoto() != null ? request.getPhoto() : " "
        );
    }

    /* ---- Método del compañero (PUT) ---- */
    @Override
    public void updateEmployee(int id, EmployeeRequest request) {
        iEmployeeRepository.updateEmployee(
                id,
                emptyToNull(request.getName()),
                emptyToNull(request.getSurname()),
                emptyToNull(request.getUsername()),
                emptyToNull(request.getPasswordHash()),
                emptyToNull(request.getShift()),
                emptyToNull(request.getPhone()),
                emptyToNull(request.getPhoto()),
                request.getRole()
        );
    }

    /**
     * Deactivates an employee by their ID (soft delete).
     * @author Luis Fernando Tolentino Segovia
     */
    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        if (!iEmployeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        iEmployeeRepository.deactivateEmployee(id);
    }

    private String emptyToNull(String value) {
        return (value == null || value.trim().isEmpty()) ? null : value;
    }
}