package com.github.lgvo.roadrunner.page;

import com.github.lgvo.roadrunner.event.EventProcessor;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Link<T extends Page> extends Element {

    private final T page;

    public Link(final WebDriver driver, final String selector, T page) {
        super(selector);
        this.page = page;
    }

    public Link(final WebDriver driver, final String selector, T page, final List<EventProcessor> events) {
        super(selector, events);
        this.page = page;
    }

    public T click() {
        findElement().click();
        processEvents();
        return page;
    }
}
