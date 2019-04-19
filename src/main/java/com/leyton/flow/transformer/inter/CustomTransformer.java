
package com.leyton.flow.transformer.inter;

import org.springframework.messaging.Message;

public interface CustomTransformer {

    Integer transformer(Message<String> message);
}
