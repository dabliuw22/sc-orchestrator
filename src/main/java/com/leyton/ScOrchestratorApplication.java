
package com.leyton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.integration.support.MessageBuilder;

import com.leyton.flow.gateway.CustomGateway;

@EnableDiscoveryClient
@SpringBootApplication
public class ScOrchestratorApplication implements CommandLineRunner {

    @Autowired
    private CustomGateway httpGateway;

    public static void main(String[] args) {
        SpringApplication.run(ScOrchestratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            httpGateway.request(MessageBuilder.withPayload("Name" + i).setHeader("ID", i).build());
        }
    }
}
