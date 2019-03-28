package com.lzkspace.springboot.demo.initilalize;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author : liaozikai
 * file : HelloApplicationRunner.java
 * 实现ApplicationRunner的类能够在springApplication启动完后
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {

    /**
     * 在容器初始化完成后，执行该方法。此方法在HelloSpringApplicationRunListener.started方法后，
     * 在此方法在HelloSpringApplicationRunListener.running方法前执行
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("HelloApplicationRunner...run....");
    }
}
