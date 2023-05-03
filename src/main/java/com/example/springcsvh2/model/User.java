package com.example.springcsvh2.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @CsvBindByName
    private long id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private int age;
    @CsvBindByName
    private Integer group_id;

    @CsvBindByName
    @CsvCustomBindByName(column = "phone", converter = PhoneNumberConverter.class)
    private String phone;

    @CsvBindByName
    @CsvCustomBindByName(column = "date", converter = DateConverter.class)
    private Date date;
}