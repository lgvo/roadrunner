package com.github.lgvo.roadrunner.page;

import com.github.lgvo.roadrunner.threadlocal.WebDriverThreadLocal;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    private final String url;
    private final String title;

    public Page(final String url, final String title) {
        this.url = url;
        this.title = title;
    }

    public void open() {
        driver().get(url);
        if (!driver().getTitle().equals(title)) {
            throw new IllegalStateException(String.format("Page title (%s) differs from excepted (%s)", driver().getTitle(), title));
        }
    }

    protected WebDriver driver() {
        return WebDriverThreadLocal.get();
    }

}
