package com.tulane.quickwork.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tulane
 * 2019/11/10
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * 自定义校验逻辑方法
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String check = "158\\d{8}";
        Pattern regex = Pattern.compile(check);
        String phone = Optional.ofNullable(value).orElse("");
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }
}
