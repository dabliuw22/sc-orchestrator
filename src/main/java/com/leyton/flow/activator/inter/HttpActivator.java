
package com.leyton.flow.activator.inter;

import org.springframework.messaging.Message;

public interface HttpActivator {

    void print(Message<?> message);
}
