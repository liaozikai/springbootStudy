package com.lzkspace.springboot.demo.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : liaozikai
 * file : Bean.java
 *  1.@Configuration表明该类为配置类，拥有该注解的类在springboot启动时能够实例化。
 *  2.@Bean则是用于实例化对象
 *  3.@ConditionalOnMissingBean(Computer.class) 等@Conditional* 注释则是表明该在某条件下才能实例化对象
 */
@Configuration // 该类为配置类，springboot启动时会扫描该注解的类
public class BeanConfig {
    
    public BeanConfig() {
        System.out.println("我能够被实例化");
    }
    
    @Bean(name = "notebookPC")
    public Computer computer() {
        return new Computer("笔记本电脑");
    }
    
    @ConditionalOnMissingBean(Computer.class)
    @Bean(name = "reversePC")
    public Computer reverseComputer() {
        return  new Computer("备用电脑");
    }
}
