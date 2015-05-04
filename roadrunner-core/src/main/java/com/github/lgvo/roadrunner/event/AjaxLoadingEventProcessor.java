package com.github.lgvo.roadrunner.event;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxLoadingEventProcessor extends EventProcessor {

    private final String selectorAjaxLoading;

    public AjaxLoadingEventProcessor(final String selectorAjaxLoading) {
        this.selectorAjaxLoading = selectorAjaxLoading;
    }

    public void process() {
        final WebElement element;
        try {
            element = (new WebDriverWait(driver(), 2)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectorAjaxLoading)));

        } catch (Exception e) {
            return;
        }

        new WebDriverWait(driver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selectorAjaxLoading)));

    }
}
