package com.tutorial.boot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Siyuan
 * @date 2024/11/01/19:21
 */
@RestController
public class TestController {
    @GetMapping("/test") // This annotation maps HTTP GET requests onto specific handler methods. 实现查询
    public List<String> test() {
        return List.of("Hello", "World!");
    }
}
