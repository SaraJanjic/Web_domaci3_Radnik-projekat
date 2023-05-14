package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Department;
import vezbe.demo.model.Employee;
import vezbe.demo.repository.DepartmentRepository;
import vezbe.demo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public List<Department> findDepartmentByEmployeeId(Long employeeId){
        Optional<Employee> foundEmployee = employeeRepository.findById(employeeId);
        if(foundEmployee.isPresent()){
            return (List<Department>) departmentRepository.findByEmployee(employeeId);
        }
        return null;
    }
}
