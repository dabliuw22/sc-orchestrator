
package com.leyton.flow.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(
        name = "customGateway")
public interface CustomGateway {

    @Gateway(
            requestChannel = "requestChannel")
    void request(Message<String> message);
}
