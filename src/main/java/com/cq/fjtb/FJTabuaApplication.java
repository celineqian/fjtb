package com.cq.fjtb;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FJTabuaApplication extends SpringBootServletInitializer {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FJTabuaApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FJTabuaApplication.class);

    }
    public static void main(String[] args) {
        SpringApplication.run(FJTabuaApplication.class, args);
        logger.debug("======================= Application Start Successful =======================");
    }
}