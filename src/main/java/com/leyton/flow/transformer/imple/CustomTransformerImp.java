
package com.leyton.flow.transformer.imple;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import com.leyton.flow.transformer.inter.CustomTransformer;

@MessageEndpoint
public class CustomTransformerImp implements CustomTransformer {

    @Override
    @Transformer(
            inputChannel = "requestChannel",
            outputChannel = "filterChannel")
    public Integer transformer(Message<String> message) {
        return Integer.parseInt(message.getHeaders().get("ID").toString());
    }
}
