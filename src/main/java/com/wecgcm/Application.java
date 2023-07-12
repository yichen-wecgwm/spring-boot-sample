package com.wecgcm;

import com.wecgcm.config.DemoConfiguration;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("${spring.application.name}")
@RequiredArgsConstructor(onConstructor_= @Autowired)
public class Application {
    private final DemoConfiguration demoConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/up")
    public String up(){
        Counter.builder("metrics.test")
                .tag("hello", "world")
                .register(Metrics.globalRegistry)
                .increment();
        return "up!";
    }

    @GetMapping("/config")
    public DemoConfiguration config(){
        return demoConfiguration;
    }
}
