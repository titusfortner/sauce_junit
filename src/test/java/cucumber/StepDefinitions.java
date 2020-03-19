package cucumber;

import com.saucelabs.framework.Browser;
import com.saucelabs.framework.pages.PageObject;
import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import data.UserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.SignUpPage;

public class StepDefinitions {
    private UserData validUser;
    private SignUpPage signUpPage;

    public SauceSession session;

    @io.cucumber.java.Before
    public void setup()
    {
        SauceOptions options = new SauceOptions();
        //TODO figure out how to set a test name using Cuke
        //options.setName();
        session = new SauceSession(options);
        RemoteWebDriver driver = session.start();
        Browser browser = new Browser(driver);
        PageObject.setBrowser(browser);
    }
    @io.cucumber.java.After
    public void after()
    {
        //TODO no clue how to get the test status from Cuke
        session.stop(true);
    }

    @Given("a user navigates to the sign up page")
    public void a_user_navigates_to_the_sign_up_page() {
        signUpPage = new SignUpPage();
        signUpPage.visit();
    }

    @When("a user enters valid information")
    public void a_user_enters_valid_information() {
        validUser = new UserData().getValidUser();
        signUpPage.signUp(validUser);
    }
    @Then("the user is successfully registered")
    public void the_user_is_successfully_registered() {
        Assert.assertTrue(new HomePage().isLoggedIn(validUser));
    }

}
