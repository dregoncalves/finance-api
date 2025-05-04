package br.com.unicuritiba.financeapi.controller;

import br.com.unicuritiba.financeapi.dto.UserResponseDTO;
import br.com.unicuritiba.financeapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDTO getUser(@PathVariable Long userId) {
        return userService.getUserWithInvestments(userId);
    }
}
