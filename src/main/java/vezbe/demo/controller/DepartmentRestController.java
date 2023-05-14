package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vezbe.demo.dto.DepartmentDto;
import vezbe.demo.model.Department;
import vezbe.demo.model.Employee;
import vezbe.demo.service.DepartmentService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/api/department")
    public ResponseEntity<List<DepartmentDto>> getDepartment(HttpSession session){
        List<Department> departmentsList = departmentService.findAll();

        Employee loggedEmployee = (Employee) session.getAttribute("employee");
        if(loggedEmployee == null){
            System.out.println("Nema sesije!");
            return ResponseEntity.badRequest().build();
        }else {
            departmentsList = departmentService.findDepartmentByEmployeeId(loggedEmployee.getId());
        }

        //DepartmentDto dto = new DepartmentDto(dep);
        List<DepartmentDto> dtos = new ArrayList<>();
        for(Department d : departmentsList){
            DepartmentDto dto = new DepartmentDto(d);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);

    }




}
