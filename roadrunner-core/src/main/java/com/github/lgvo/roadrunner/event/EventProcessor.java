package com.github.lgvo.roadrunner.event;

import com.github.lgvo.roadrunner.threadlocal.WebDriverThreadLocal;
import org.openqa.selenium.WebDriver;

public abstract class EventProcessor {

    public abstract void process();

    protected WebDriver driver() {
        return WebDriverThreadLocal.get();
    }

}
