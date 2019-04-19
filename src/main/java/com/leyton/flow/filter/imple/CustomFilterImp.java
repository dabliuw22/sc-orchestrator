
package com.leyton.flow.filter.imple;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

import com.leyton.flow.filter.inter.CustomFilter;

@MessageEndpoint
public class CustomFilterImp implements CustomFilter {

    @Override
    @Filter(
            inputChannel = "filterChannel",
            outputChannel = "endChannel")
    public boolean filter(Message<Integer> message) {
        return message.getPayload() % 2 == 0;
    }
}
