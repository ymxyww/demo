package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis 测试
     */
    @Test
    public void contextLoads() {

        stringRedisTemplate.opsForValue().set("name", "guanguan");
        String val = stringRedisTemplate.opsForValue().get("name");
        System.out.println(val);

    }

    /**
     * jdk8 测试
     */
    @Test
    public void jdk8() {

        System.out.println("--------------------start---------------------");



        System.out.println("--------------------end---------------------");

    }

    /**
     * 测试 遍历实体类的属性，根据属性的注解来判断是否必填
     */
    @Test
    public void attributeRequired() throws IllegalAccessException {

        User user = new User(null, 20, 1);
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);//对私有字段的访问取消权限检查。暴力访问。
            if ("sex".equals(field.getName())) {
                field.set(user, 2);//设置字段的值
            }
            System.out.println(field.getName() + " : " + field.get(user));//field.getName()获取字段名， field.get(user)获取字段的值
            AttributeRequired attributeRequired = field.getAnnotation(AttributeRequired.class);//AttributeRequired是注解名
            System.out.println(attributeRequired);
        }


    }

}
