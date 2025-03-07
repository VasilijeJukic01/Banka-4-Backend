package rs.banka4.user_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import rs.banka4.user_service.controller.docs.EmployeeApiDocumentation;
import rs.banka4.user_service.dto.EmployeeDto;
import rs.banka4.user_service.dto.EmployeeResponseDto;
import rs.banka4.user_service.dto.PrivilegesDto;
import rs.banka4.user_service.dto.requests.CreateEmployeeDto;
import rs.banka4.user_service.dto.requests.UpdateEmployeeDto;
import rs.banka4.user_service.service.abstraction.EmployeeService;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController implements EmployeeApiDocumentation {

    private final EmployeeService employeeService;

    @Override
    @GetMapping("/privileges")
    public ResponseEntity<PrivilegesDto> getPrivileges() {
        return employeeService.getPrivileges();
    }

    @Override
    @GetMapping("/me")
    public ResponseEntity<EmployeeResponseDto> me(Authentication auth) {
        return employeeService.getMe((String) auth.getCredentials());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> createEmployee(@RequestBody @Valid CreateEmployeeDto createEmployeeDto) {
        return employeeService.createEmployee(createEmployeeDto);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeDto>> getEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String position,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return employeeService.getAll(firstName, lastName, email, position, PageRequest.of(page, size));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable String id,
                                               @RequestBody @Valid UpdateEmployeeDto updateEmployeeDto) {
        return employeeService.updateEmployee(id, updateEmployeeDto);
    }
}
