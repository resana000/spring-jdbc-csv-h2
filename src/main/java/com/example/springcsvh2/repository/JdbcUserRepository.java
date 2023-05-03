package com.example.springcsvh2.repository;

import com.example.springcsvh2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {

    private static final String SAVE_USER_SQL =
            "insert into user (name, age, group_id, phone, date) values(?, ?, ?, ?, ?)";

    private static final String SELECT_USER_LESSER =
            "select * from user where age < ";

    final JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                SAVE_USER_SQL, user.getName(), user.getAge(),
                user.getGroup_id(), user.getPhone(), user.getDate());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from user", (rs, row) -> User.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .group_id(rs.getInt("group_id"))
                        .phone(rs.getString("phone"))
                        .date(rs.getDate("date"))
                        .build()
        );
    }

    @Override
    public List<User> findAllByAgeLesserThan(int age) {
        return jdbcTemplate.query(SELECT_USER_LESSER + age, (rs, row) ->
                User.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .group_id(rs.getInt("group_id"))
                        .phone(rs.getString("phone"))
                        .date(rs.getDate("date"))
                        .build());
    }
}
