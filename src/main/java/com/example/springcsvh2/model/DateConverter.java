package com.example.springcsvh2.model;

import com.opencsv.bean.AbstractBeanField;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;

public class DateConverter extends AbstractBeanField<User, Object> {
    @SneakyThrows
    @Override
    protected Object convert(String value) {
        if (value.equals("null") || value == null) return null;
        return new SimpleDateFormat("yyyy-MM-dd").parse(value);
    }
}
