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

    public User createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setEmail(createUserDto.getEmail());
        user.setPasswordHash(hashPassword(createUserDto.getPassword()));

        return this.userRepository.save(user);
    }

    public Optional<User> getUserById(String userId) {
        return this.userRepository.findById(userId);
    }

    public Optional<User> login(CreateUserDto createUserDto) {
        Optional<User> user = this.userRepository.findByEmail(createUserDto.getEmail());
        if (user.isPresent()) {
            User userEntity = user.get();
            if (verifyPassword(createUserDto.getPassword(), userEntity.getPasswordHash())) {
                return Optional.of(userEntity);
            }
        }
        //throw exception
        return Optional.empty();
    }

    public String hashPassword(String password){
        Argon2 argon2 = Argon2Factory.create();
        char[] pwd = password.toCharArray();
        String hash = argon2.hash(10, 65536, 1, pwd);
        argon2.wipeArray(pwd);
        return hash;
    }

    public Boolean verifyPassword(String password, String hash){
        Argon2 argon2 = Argon2Factory.create();
        return argon2.verify(hash, password.toCharArray());
    }
}
