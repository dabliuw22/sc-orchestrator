
package com.leyton.flow.router.inter;

import org.springframework.messaging.Message;

public interface CustomRouter {

    String route(Message<Integer> message);
}
