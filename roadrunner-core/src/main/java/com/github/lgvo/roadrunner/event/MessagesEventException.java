package com.github.lgvo.roadrunner.event;

import java.util.Collections;
import java.util.Map;

public class MessagesEventException extends RuntimeException {

    private final Map<String, Integer> messages;

    public MessagesEventException(final Map<String, Integer> messages) {
        this.messages = Collections.unmodifiableMap(messages);
    }

    public boolean contains(final String message) {
        return messages.containsKey(message);
    }

    public Integer totalOf(final String message) {
        if (contains(message)) {
            return messages.get(message);
        }

        return 0;
    }
}
