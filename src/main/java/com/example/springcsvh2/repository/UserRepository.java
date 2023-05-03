package com.example.springcsvh2.repository;

import com.example.springcsvh2.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    List<User> findAllByAgeLesserThan(int age);

}
