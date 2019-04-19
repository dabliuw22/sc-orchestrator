
package com.leyton.flow.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(
        name = "microserviceOneGateway")
public interface MicroserviceOneGateway {

    @Gateway(
            requestChannel = "httpRequestChannel")
    void request(String message);
}
