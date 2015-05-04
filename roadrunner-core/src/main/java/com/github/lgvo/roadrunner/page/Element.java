package com.github.lgvo.roadrunner.page;

import com.github.lgvo.roadrunner.event.EventProcessor;
import com.github.lgvo.roadrunner.threadlocal.WebDriverThreadLocal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class Element {

    private final String selector;
    private final List<EventProcessor> events;

    public Element(final String selector) {
        this.selector = selector;
        events = Collections.emptyList();
    }

    public Element(final String selector, final List<EventProcessor> events) {
        this.selector = selector;
        this.events = events;
    }

    protected WebElement findElement() {
        return driver().findElement(By.cssSelector(selector));
    }

    public void processEvents() {
        for (final  EventProcessor event : events)
            event.process();
    }

    protected WebDriver driver() {
        return WebDriverThreadLocal.get();
    }

}
