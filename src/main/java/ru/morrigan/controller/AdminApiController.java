package ru.morrigan.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.morrigan.model.User;
import ru.morrigan.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
    private final UserServiceImpl userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> response = userService.getUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createUser (@RequestBody @Valid User user) {
        userService.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<HttpStatus> editUser (@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
