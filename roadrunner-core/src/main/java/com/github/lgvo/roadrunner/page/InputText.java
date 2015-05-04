package com.github.lgvo.roadrunner.page;

import com.github.lgvo.roadrunner.event.EventProcessor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InputText extends Element {

    public InputText(final String selector) {
        super(selector);
    }

    public InputText(final String selector, final List<EventProcessor> events) {
        super(selector, events);
    }

    public String fill(final String text) {
        WebElement element = findElement();
        element.sendKeys(text);
        return  element.getAttribute("value");
    }

}
