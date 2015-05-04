package com.github.lgvo.roadrunner.threadlocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverThreadLocal {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return new FirefoxDriver();
        }
    };

    public static WebDriver get() {
        return THREAD_LOCAL.get();
    }

}
