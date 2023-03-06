package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private UserServiceImp userService;

    public MvcConfig(UserServiceImp userService) {
        this.userService = userService;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("user");
    }
}
