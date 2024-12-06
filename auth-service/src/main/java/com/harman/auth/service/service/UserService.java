package com.harman.auth.service.service;

import com.harman.auth.service.dto.UserCredential;
import com.harman.auth.service.entity.User;
import com.harman.auth.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public boolean validateUser(UserCredential credential) {
        Optional<User> userObj = repository.findByEmail(credential.email());
        if(userObj.isPresent()) {
            User user = userObj.get();
            return user.getPassword().equals(credential.password());
        }
        return false;
    }
}
