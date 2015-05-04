package com.github.lgvo.roadrunner.event;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesEventProcessor extends  EventProcessor {

    private final String selector;

    public MessagesEventProcessor(final String selector) {
        this.selector = selector;
    }

    @Override
    public void process() {
        final List<WebElement> list;
        try {
            list = new WebDriverWait(driver(), 2).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(selector)));
        } catch (Exception e) {
           return;
        }

        if (list != null && !list.isEmpty()) {
            final Map<String, Integer> map = new HashMap<String, Integer>();
            for(final WebElement element : list) {
                final String messageText = element.getText();
                if (map.containsKey(messageText)) {
                    map.put(messageText, map.get(messageText) + 1);
                } else {
                    map.put(messageText, 1);
                }
            }
        }

    }
}
