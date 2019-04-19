
package com.leyton.flow.activator.imple;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.web.client.RestTemplate;

import com.leyton.domain.GreetingResponse;
import com.leyton.flow.activator.inter.HttpActivator;

@MessageEndpoint
public class HttpActivatorImp implements HttpActivator {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpActivatorImp.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @ServiceActivator(
            inputChannel = "httpRequestChannel")
    public void print(Message<?> message) {
        LOGGER.info("PAYLOAD: [{}], HEADERS: [{}]", message.getPayload(), message.getHeaders());
        Map<String, Object> params = new HashMap<>();
        params.put("name", message.getPayload());
        GreetingResponse response = restTemplate.getForObject(
                "http://microservice-one/greeting/{name}", GreetingResponse.class, params);
        LOGGER.info("RESPONSE: {}", response);
    }
}
