package tests;

import config.ConfigProvider;
import org.junit.jupiter.api.Test;
import testdata.TestData;


public class AuthorizationTests extends BaseTest {

    @Test
    void successfulLoginTest() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail(ConfigProvider.testDataConfig.validEmail())
                .typePassword(ConfigProvider.testDataConfig.validPassword())
                .pressLoginButton();

        accountPage.openPage()
                .checkEmail(ConfigProvider.testDataConfig.validEmail());
    }

    @Test
    void loginWithWrongCredentials() {
        mainPage.openPage()
                .openLoginForm();
        mainPage.loginForm.typeEmail(TestData.invalidEmail)
                .typePassword(TestData.invalidPassword)
                .pressLoginButton()
                .checkErrorMessage(TestData.formError);
    }

    @Test
    void successfulLogOut() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail(ConfigProvider.testDataConfig.validEmail())
                .typePassword(ConfigProvider.testDataConfig.validPassword())
                .pressLoginButton();

        accountPage.openPage()
                .logout()
                .openPage()
                .checkUserNotAuthorized();

    }
}