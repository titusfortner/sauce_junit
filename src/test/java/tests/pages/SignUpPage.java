package test.java.tests.pages;

import com.saucelabs.framework.elements.Element;
import com.saucelabs.framework.elements.TextField;
import com.saucelabs.framework.pages.OnPage;
import org.openqa.selenium.By;
import test.java.tests.data.UserData;

@OnPage(path="/sign_up")
public class SignUpPage extends BasePage {

    private TextField email = browser.textField(By.id("user_email"));
    private TextField password = browser.textField(By.id("user_password"));
    private Element submit = browser.element(By.cssSelector("[data-test=submit]"));

    public void signUp(UserData userData) {
        fillForm(userData);
        submit.click();
    }

    public void signUp() {
        signUp(new UserData());
    }
}
