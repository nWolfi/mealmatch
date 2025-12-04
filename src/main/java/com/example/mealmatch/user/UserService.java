package com.example.mealmatch.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto)
    {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword_hash());

        return this.userRepository.save(user);
    }
}
