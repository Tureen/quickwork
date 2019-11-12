package com.tulane.quickwork.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Tulane
 * 2019/11/10
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// 约束注解关联的验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    String message() default "手机号校验错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
