package vezbe.demo.dto;

import vezbe.demo.model.Company;
import vezbe.demo.model.Department;

public class DepartmentDto {

    private Long id;

    private  String department_name;

    private Company company_department_name;


    public DepartmentDto(Department dep) {
        this.id = dep.getId();
        this.department_name = dep.getName();
        this.company_department_name = dep.getCompany();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Company getCompany_department_name() {
        return company_department_name;
    }

    public void setCompany_department_name(Company company_department_name) {
        this.company_department_name = company_department_name;
    }

    public void add(DepartmentDto dto) {
    }
}
