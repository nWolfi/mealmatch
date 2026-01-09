package com.example.mealmatch.user;

import org.springframework.stereotype.Service;

import java.util.Optional;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


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
        user.setPassword(hashPassword(userDto.getPassword_hash()));

        return this.userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {
        return this.userRepository.findById(userId);
    }

    public Optional<User> login(UserDto userDto) {
        Optional<User> user = this.userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            User userEntity = user.get();
            if (verifyPassword(userDto.getPassword_hash(), userEntity.getPassword())) {
                return Optional.of(userEntity);
            }
        }
        return Optional.empty();
    }

    public String hashPassword(String password){
        Argon2 argon2 = Argon2Factory.create();
        char[] pwd = password.toCharArray();
        String hash = argon2.hash(10, 65536, 1, pwd);
        argon2.wipeArray(pwd);
        return hash;
    }

    verifyPassword(String password, String hash){
        Argon2 argon2 = Argon2Factory.create();
        return argon2.verify(hash, password.toCharArray());
    }
}
