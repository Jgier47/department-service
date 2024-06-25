package net.java.app.department_service.service.impl;

import java.util.Optional;
import lombok.AllArgsConstructor;
import net.java.app.department_service.dto.DepartmentDto;
import net.java.app.department_service.entity.Department;
import net.java.app.department_service.exceptions.DepartmentAlreadyExistsException;
import net.java.app.department_service.exceptions.ResourceNotFoundException;
import net.java.app.department_service.mappers.DepartmentMapper;
import net.java.app.department_service.repository.DepartmentRepository;
import net.java.app.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired private DepartmentRepository departmentRepository;
  @Autowired private DepartmentMapper departmentMapper;

  @Override
  public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
    checkIfDepartmentAlreadyExists(departmentDto);

    return departmentMapper.departmentToDepartmentDto(
        departmentRepository.save(departmentMapper.departmentDtoToDepartment(departmentDto)));
  }

  private void checkIfDepartmentAlreadyExists(DepartmentDto departmentDto) {
    Optional<Department> department =
        departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());
    if (department.isPresent())
      throw new DepartmentAlreadyExistsException(
          String.format(
              "Department with code %s already exists", departmentDto.getDepartmentCode()));
  }

  @Override
  public DepartmentDto getDepartmentByCode(String departmentCode) {

    Department department =
        departmentRepository
            .findByDepartmentCode(departmentCode)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException("Department", "DepartmentCode", departmentCode));

    return departmentMapper.departmentToDepartmentDto(department);
  }
}
