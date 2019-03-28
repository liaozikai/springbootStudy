package com.lzkspace.springboot.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : liaozikai
 * file : Person.java
 * 1.spring容器要扫表到该类，需要加上@Component注解
 * 2.该类要与属性文件字段绑定，有两种方式
 *  1.加上 @ConfigurationProperties(prefix = "person")，通过person.name=名字的方式来设置字段值
 *  2.对每个字段通过@Value("${person.name}")注解的方式绑定字段与配置文件字段的值
 * 3.若要约束每个字段的规则，可通过@Validated与@ConfigurationProperties(prefix = "person")两个注解，并且在每个
 * 字段上加上约束注解如@NotNull来约束字段的值。（@Value("${person.name}")与@Validated不能配套使用）
 * 4.@PropertySource(value = {"classpath:config/person.properties"}) //执行加载属性的路径
 *   若是application.properties的person内容未注释，则该注释文件会覆盖指定路径下的文件内容
 */
@PropertySource(value = {"classpath:config/person.properties"}) //执行加载属性的路径
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    
    @NotNull
//  @Value("${person.name}")
    private String name;
    private Integer age;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
