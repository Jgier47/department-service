package net.java.app.department_service.repository;

import java.util.Optional;
import net.java.app.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Optional<Department> findByDepartmentCode(String departmentCode);
}
