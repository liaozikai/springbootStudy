package com.lzkspace.springboot.demo.initilalize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author : liaozikai
 * file : HelloHelloSpringApplicationRunListener.java
 * 在 META-INF/spring.factories 文件夹下配置 org.springframework.context.ApplicationContextInitializer
 * 则在springboot启动时，会扫描实现了SpringApplicationRunListener的实现类
 * 通过实现接口的方法，能够在系统启动的不同阶段实现自己的方法
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {
    }

    /**
     * 加载完所有pom.xml依赖的包后执行方法
     */
    @Override
    public void starting() {
        System.out.println("HelloSpringApplicationRunListener ... strating ...");
    }

    /**
     * 执行完starting方法后执行环境准备方法
     * @param environment
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("HelloSpringApplicationRunListener ... environmentPrepared ..." + o);
    }

    /**
     * 容器初始化完成后，再执行容器准备方法，其过程包括读取主类的class文件，读取类路径下的application.properties/yml
     * 等配置文件的属性配置等。该方法在HelloApplicationContextInitializer.initialize方法后执行
     * @param context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener ... contextPrepared ...");
    }

    /**
     * 容器准备完成后，执行容器加载完成后操作。
     * 该方法执行在内嵌容器Tomcat初始化之前
     * @param context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener ... contextLoaded ...");
    }

    /**
     * 容器加载完成后，执行该方法。在容器加载之后，该方法执行之前，
     * 执行了Tomcat的初始化，还有内嵌WebApplicationContext的初始化，
     * ExecutorService的初始化，Tomcat端口和访问路径的设置等。均可在Console上看出来
     * @param context
     */
    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener ... started ...");
    }

    /**
     * 该方法在执行完HelloApplicationRunner.run方法后执行
     * @param context
     */
    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("HelloSpringApplicationRunListener ... running ...");
    }

    /**
     * 该方法在容器初始化失败后才执行
     * @param context
     * @param exception
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("HelloSpringApplicationRunListener ... failed ...");
    }
    
}
