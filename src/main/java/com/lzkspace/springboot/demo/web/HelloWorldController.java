package com.lzkspace.springboot.demo.web;

import com.example.startdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : liaozikai
 * file : HelloWorldController.java
 */

@RestController
public class HelloWorldController {


    /**
     * 通过mvn install生成jar包打到仓库中，引入自定义依赖
     * <groupId>com.example</groupId><artifactId>startdemo</artifactId>给该项目使用
     * 1.HelloProperties：通过配置文件绑定该文件字段属性 应该还要加上@Component
     * 2.HelloServiceAutoConfiguration: 配置类，springboot启动时，通过@Configuration扫描该配置类，
     * 且通过@ConditionalOnWebApplication判断是否满足实例化条件
     * 通过@EnableConfigurationProperties({HelloProperties.class}) 将该类和HelloProperties进行绑定，
     * 故而在HelloServiceAutoConfiguration可注入HelloProperties
     * 3.HelloService:在HelloServiceAutoConfiguration中，用@Bean来实例化HelloService对象
     */
    @Autowired
    HelloService helloService;
    
    @RequestMapping("/hello")
    public String getHello() {
        return  helloService.sayHelloLzkSpace("王者荣耀");
    }
    
}
