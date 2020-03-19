package tests;

import org.junit.Assert;
import org.junit.Test;
import tests.apis.AuthenticationAPI;
import tests.data.UserData;
import tests.pages.HomePage;
import tests.pages.SignUpPage;

public class AuthenticationTest extends BaseTest {
    @Test
    public void creates() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.visit();
        UserData userData = new UserData();
        signUpPage.signUp(userData);

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isLoggedIn(userData));
    }

    @Test
    public void logsIn() {
        AuthenticationAPI authenticationAPI = new AuthenticationAPI();
        UserData userData = authenticationAPI.createUser();

        HomePage homePage = new HomePage();
        homePage.visit();
        homePage.addCookie("remember_token", userData.getId());
        homePage.visit();

        Assert.assertTrue(homePage.isLoggedIn());
    }

    @Test
    public void logsOut() {
        AuthenticationAPI authenticationAPI = new AuthenticationAPI();
        UserData userData = authenticationAPI.createUser();

        HomePage homePage = new HomePage();
        homePage.visit();
        homePage.addCookie("remember_token", userData.getId());
        homePage.visit();

        homePage.logOut();
        Assert.assertFalse(homePage.isLoggedIn());
    }
}
