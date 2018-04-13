package com.example.sbautoconfigtest;

import com.sb.test.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义starter自动化配置HelloService
 */
@RestController
public class HelloController {
    //注入自定义starter内逻辑
    @Autowired
    HelloService helloService;

    /**
     * 测试访问地址/hello
     *
     * @return 格式化字符串
     */
    @RequestMapping(value = "/hello")
    public String sayHello() {
        System.out.println(helloService.sayHello());
        return helloService.sayHello();
    }
}