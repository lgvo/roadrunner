package com.github.lgvo.roadrunner.page;

import com.github.lgvo.roadrunner.event.EventProcessor;

import java.util.List;

public class Button<T extends Page> extends Element {

    private final T next;

    public Button(final String selector, final T nextPage) {
        super(selector);
        this.next = nextPage;
    }

    public Button(final String selector, final List<EventProcessor> events, final T nextPage) {
        super(selector, events);
        this.next = nextPage;
    }

    public T click() {
        findElement().click();
        processEvents();
        return next;
    }


}
