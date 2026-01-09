package com.example.mealmatch.user;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody() UserDto userDto){
        return this.userService.createUser(userDto);
    }

    @GetMapping()
    public Optional<User> getUserById(Long userId){
        return this.userService.getUserById(userId);
    }

    @GetMapping("/login")
    public Optional<User> login(UserDto userDto) {
        return this.userService.login(userDto);
    }
}
