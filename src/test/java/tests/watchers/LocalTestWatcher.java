package test.java.tests.watchers;

import lombok.Getter;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalTestWatcher extends BaseTestWatcher {
    @Getter private WebDriver driver;

    protected void starting(Description description) {
        driver = new ChromeDriver();
    }

    protected void finished(Description description) {
        driver.quit();
    }
}
