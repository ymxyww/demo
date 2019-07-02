package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})//可以定义在方法上
@Retention(RetentionPolicy.RUNTIME)//运行有效,存在class字节码文件中
public @interface AttributeRequired {
    int value() default 0;
}
