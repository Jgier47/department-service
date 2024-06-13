package net.java.app.department_service.mappers;

import net.java.app.department_service.dto.DepartmentDto;
import net.java.app.department_service.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

  Department departmentDtoToDepartment(DepartmentDto departmentDto);

  DepartmentDto departmentToDepartmentDto(Department department);
}
