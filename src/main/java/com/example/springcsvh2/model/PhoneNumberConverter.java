package com.example.springcsvh2.model;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.opencsv.bean.AbstractBeanField;
import lombok.SneakyThrows;

public class PhoneNumberConverter extends AbstractBeanField<User, Object> {
    @SneakyThrows
    @Override
    protected Object convert(String value) {
        if (value.equals("null") || value == null || value.isEmpty()) return null;
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        String number = null;
        try {
            number = util.format(util.parse(value, "RU"), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        } catch (NumberParseException e) {
            if (e.getErrorType() == NumberParseException.ErrorType.NOT_A_NUMBER && value.length() == 10) {
                number = util.format(util.parse("+7" + value, "RU"), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
            } else {
                System.err.println("NumberParseException was thrown: " + e.toString());
                throw e;
            }
        }
        return number;
    }
}
