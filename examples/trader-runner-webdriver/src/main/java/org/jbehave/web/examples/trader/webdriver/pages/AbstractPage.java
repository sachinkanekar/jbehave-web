package org.jbehave.web.examples.trader.webdriver.pages;

import static org.junit.Assert.fail;

import java.util.List;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public abstract class AbstractPage extends WebDriverPage {

    public AbstractPage(WebDriverProvider driverProvider) {
        super(driverProvider);
    }
    
    public void found(String text) {
        found(getPageSource(), text);
    }

    public void found(String pageSource, String text) {
        if (!pageSource.contains(escapeHtml(text))) {
            fail("Text: '" + text + "' not found in page '" + pageSource + "'");
        }
    }

    public void found(List<String> texts) {
        for (String text : texts) {
            found(text);
        }
    }

    public void notFound(String text) {
        found(getPageSource(), text);
    }

    public void notFound(String pageSource, String text) {
        if (pageSource.contains(escapeHtml(text))) {
            fail("Text: '" + text + "' found in page '" + pageSource + "'");
        }
    }

    private String escapeHtml(String text) {
        return text.replace("<", "&lt;").replace(">", "&gt;");
    }

}