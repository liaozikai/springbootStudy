package com.lzkspace.springboot.demo.initilalize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : liaozikai
 * file : HelloApplicationContextInitializer.java
 * 在 META-INF/spring.factories 文件夹下配置 org.springframework.context.ApplicationContextInitializer
 *  则在springboot启动时，会扫描实现了ApplicationContextInitializer的实现类
 *  容器初始化时会自动执行initialize方法，实现自己需要的功能
 */
public class HelloApplicationContextInitializer  implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * 环境准备完后启动容器初始化，该方法在HelloSpringApplicationRunListener.environmentPrepared后执行
     * @param applicationContext
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("HelloApplicationContextInitializer .... initialize... " + applicationContext);
    }
} 