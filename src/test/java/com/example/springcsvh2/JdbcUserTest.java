package com.example.springcsvh2;

import com.example.springcsvh2.controller.UserController;
import com.example.springcsvh2.model.User;
import com.example.springcsvh2.repository.UserRepository;
import com.example.springcsvh2.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JdbcUserTest {


    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    void shouldOnceCallSaveAllMethod() {
        userController.uploadCSVFile(getFile());
        List<User> users = userService.getAll();
        Assertions.assertTrue(users.size() == 4);
    }

    @Test
    void checkSelectyQuery() {
        userController.uploadCSVFile(getFile());
        List<User> users = userService.getByAge(30);
        log.info("\n Result: \n");
        users.forEach(System.out::println);
        Assertions.assertTrue(users.size() == 2);
        Assertions.assertTrue(users.stream().allMatch(user -> user.getAge() < 30));

        log.info("Phones: {}", users.stream().map(User::getPhone).collect(Collectors.toList()));
    }

    @SneakyThrows
    private MockMultipartFile getFile() {
        return new MockMultipartFile(
                "file",
                "clients.csv",
                "text/csv",
                new ClassPathResource("clients.csv").getInputStream());
    }

}