package vn.edu.crs.registration_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.edu.crs.registration_service.dto.RegistrationRequestDTO;
import vn.edu.crs.registration_service.entity.Registration;
import vn.edu.crs.registration_service.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    // 1. Xem tất cả danh sách đăng ký (Mở trực tiếp trên Web / Chrome)
    @GetMapping
    public List<Registration> getAll() {
        return registrationService.getAll();
    }

    // 2. Xem thông tin 1 bản ghi đăng ký theo ID trên Web
    @GetMapping("/{id}")
    public Registration getById(@PathVariable Long id) {
        return registrationService.getById(id);
    }

    // 3. Đăng ký môn học (POST Request)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Registration register(@Valid @RequestBody RegistrationRequestDTO dto) {
        return registrationService.register(dto);
    }

    // 4. Hủy đăng ký (DELETE Request)
    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        registrationService.cancel(id);
    }
}