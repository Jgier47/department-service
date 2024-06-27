package net.java.app.department_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.java.app.department_service.dto.DepartmentDto;
import net.java.app.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "Department Service - Department Controller",
    description = "Department Controller exposes REST APIs for Department Service")
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

  @Autowired private DepartmentService departmentService;

  @Operation(
      summary = "Save Department REST API",
      description = "Save Department REST API is used to save department object in a database")
  @ApiResponse(responseCode = "201", description = "HTTP Status 201 Created")
  @PostMapping
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
    return new ResponseEntity<>(
        departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
  }

  @Operation(
      summary = "Get Department REST API",
      description = "Get Department REST API is used to get department object from the database")
  @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
  @GetMapping("{department-code}")
  public ResponseEntity<DepartmentDto> getDepartment(
      @PathVariable("department-code") String departmentCode) {
    return new ResponseEntity<>(
        departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
  }
}
