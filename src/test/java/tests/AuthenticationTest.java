package tests;

import org.junit.Assert;
import org.junit.Test;
import apis.AuthenticationAPI;
import data.UserData;
import pages.HomePage;
import pages.SignUpPage;

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
        UserData userData = authenticationAPI.createRandomUser();

        HomePage homePage = new HomePage();
        homePage.visit();
        homePage.addCookie("remember_token", userData.getId());
        homePage.visit();

        Assert.assertTrue(homePage.isLoggedIn());
    }

    @Test
    public void logsOut() {
        AuthenticationAPI authenticationAPI = new AuthenticationAPI();
        UserData userData = authenticationAPI.createRandomUser();

        HomePage homePage = new HomePage();
        homePage.visit();
        homePage.addCookie("remember_token", userData.getId());
        homePage.visit();

        homePage.logOut();
        Assert.assertFalse(homePage.isLoggedIn());
    }
}
