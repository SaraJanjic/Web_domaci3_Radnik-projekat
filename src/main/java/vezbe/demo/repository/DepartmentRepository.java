package vezbe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vezbe.demo.model.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    @Query("SELECT d from Department  d JOIN d.employees e WHERE e.id = :employeeId")
    List<Department> findByEmployee(@Param("employeeId")Long employeeId);

}
