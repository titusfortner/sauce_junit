package test.java.tests;

import com.saucelabs.framework.Browser;
import com.saucelabs.framework.pages.PageObject;
import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
    public SauceSession session;

    @Rule
    public SauceTestWatcher testWatcher = new SauceTestWatcher();

    @Rule
    public TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @Before
    public void setup() {
        SauceOptions options = new SauceOptions();
        options.setName(name.getMethodName());
        session = new SauceSession(options);
        testWatcher.setSession(session);
        RemoteWebDriver driver = session.start();
        Browser browser = new Browser(driver);
        PageObject.setBrowser(browser);
    }
}
