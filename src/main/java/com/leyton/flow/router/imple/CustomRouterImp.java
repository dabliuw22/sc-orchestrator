
package com.leyton.flow.router.imple;

import org.springframework.messaging.Message;

import com.leyton.flow.router.inter.CustomRouter;

//@MessageEndpoint
public class CustomRouterImp implements CustomRouter {

    @Override
    // @Router(inputChannel = "filterChannel")
    public String route(Message<Integer> message) {
        return message.getPayload() % 2 == 0 ? "evenChannel" : "oddChannel";
    }
}
