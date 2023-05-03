package com.example.springcsvh2.service;

import com.example.springcsvh2.model.User;
import com.example.springcsvh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveAll(List<User> users) {
        users.forEach(this::save);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getByAge(int age) {
        return userRepository.findAllByAgeLesserThan(age);
    }
}
