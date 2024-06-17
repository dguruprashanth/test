package com.generate.rewards.service;

import com.generate.rewards.model.Customer;
import com.generate.rewards.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<Customer> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
