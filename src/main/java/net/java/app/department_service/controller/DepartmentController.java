package net.java.app.department_service.controller;

import lombok.AllArgsConstructor;
import net.java.app.department_service.dto.DepartmentDto;
import net.java.app.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

  @Autowired private DepartmentService departmentService;

  @PostMapping
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
    return new ResponseEntity<>(
        departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
  }

  @GetMapping("{department-code}")
  public ResponseEntity<DepartmentDto> getDepartment(
      @PathVariable("department-code") String departmentCode) {
    return new ResponseEntity<>(
        departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
  }
}
