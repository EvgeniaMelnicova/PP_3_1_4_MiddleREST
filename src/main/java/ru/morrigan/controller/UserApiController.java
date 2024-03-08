package ru.morrigan.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.morrigan.model.User;
import ru.morrigan.service.UserServiceImpl;

import java.security.Principal;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserApiController {

    private final UserServiceImpl usersService;

    @GetMapping
    public ResponseEntity<User> getUser(Principal principal) {
        User user = usersService.getUserByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
