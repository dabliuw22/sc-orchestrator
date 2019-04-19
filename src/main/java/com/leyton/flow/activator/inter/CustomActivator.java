
package com.leyton.flow.activator.inter;

import org.springframework.messaging.Message;

public interface CustomActivator {

    void print(Message<Integer> message);
}
