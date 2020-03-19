package test.java.tests;

import com.saucelabs.framework.Browser;
import com.saucelabs.framework.pages.PageObject;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import test.java.tests.watchers.BaseTestWatcher;
import test.java.tests.watchers.TestContext;

public class BaseTest {
    public Browser browser;

    @Rule
    public BaseTestWatcher testWatcher = TestContext.implementation();

    @Before
    public void setup() {
        WebDriver driver = testWatcher.getDriver();
        browser = new Browser(driver);
        PageObject.setBrowser(browser);
    }
}