package net.java.app.department_service.service;

import net.java.app.department_service.dto.DepartmentDto;

public interface DepartmentService {

  DepartmentDto saveDepartment(DepartmentDto departmentDto);

  DepartmentDto getDepartmentByCode(String departmentCode);
}
