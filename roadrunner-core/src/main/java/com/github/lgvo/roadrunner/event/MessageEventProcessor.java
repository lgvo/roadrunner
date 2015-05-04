package com.github.lgvo.roadrunner.event;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageEventProcessor extends EventProcessor {
    private final String selector;

    public MessageEventProcessor(final String selector) {
        this.selector = selector;
    }

    @Override
    public void process() {

        try {
            final WebElement message = (new WebDriverWait(driver(), 1).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector))));
            throw new MessageEventException(message.getText());
        } catch (Exception e) {

        }

    }
}
