
package com.leyton.flow.filter.inter;

import org.springframework.messaging.Message;

public interface CustomFilter {

    boolean filter(Message<Integer> message);
}
