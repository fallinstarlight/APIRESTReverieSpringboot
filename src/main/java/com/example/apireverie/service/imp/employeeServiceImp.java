package com.example.apireverie.service.imp;

import com.example.apireverie.entity.Employee;
import com.example.apireverie.model.response.EmployeeResponse;
import com.example.apireverie.repository.IEmployeeRepository;
import com.example.apireverie.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class employeeServiceImp implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /* Método para devolver todos los registros de la tabla usando findall()*/
    @Override
    public List<EmployeeResponse> getEmployees() {
        List<EmployeeResponse> response= new ArrayList<>();
        List<Employee> employees = iEmployeeRepository.findAll();

        /* Instanciar los objetos de tipo empleado y asignarles sus valores */
        for(Employee e : employees){
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
}
