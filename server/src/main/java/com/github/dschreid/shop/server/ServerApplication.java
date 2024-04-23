package com.github.dschreid.shop.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Starts the application
 *
 * @author dschreid
 */
@SpringBootApplication
public class ServerApplication {
    private ConfigurableApplicationContext context;

    public void start(String[] args) {
        if (context == null) {
            context = SpringApplication.run(ServerApplication.class, args);
            context.registerShutdownHook();
        }
    }

}
