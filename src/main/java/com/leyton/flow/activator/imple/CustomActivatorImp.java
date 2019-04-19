
package com.leyton.flow.activator.imple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import com.leyton.flow.activator.inter.CustomActivator;

@MessageEndpoint
public class CustomActivatorImp implements CustomActivator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomActivatorImp.class);

    @Override
    @ServiceActivator(
            inputChannel = "endChannel")
    public void print(Message<Integer> message) {
        LOGGER.info("PAYLOAD: [{}], HEADERS: [{}]", message.getPayload(), message.getHeaders());
    }
}
