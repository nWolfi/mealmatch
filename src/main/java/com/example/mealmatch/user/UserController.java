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

    @PostMapping()
    public User createUser(@RequestBody() CreateUserDto createUserDto){
        return this.userService.createUser(createUserDto);
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") String userId){
        return this.userService.getUserById(userId);
    }

    @GetMapping("/login")
    public Optional<User> login(CreateUserDto createUserDto) {
        return this.userService.login(createUserDto);
    }
}
