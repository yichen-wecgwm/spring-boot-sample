package com.wecgcm;

import com.wecgcm.config.DemoConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor(onConstructor_= @Autowired)
public class Application {
    private final DemoConfiguration demoConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/up")
    public String readyProbe(){
        return "up!";
    }

    @GetMapping("/config")
    public DemoConfiguration config(){
        return demoConfiguration;
    }
}
