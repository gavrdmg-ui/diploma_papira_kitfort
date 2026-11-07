package tests;

import config.ConfigProvider;
import org.junit.jupiter.api.Test;


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
        mainPage.loginForm.typeEmail("email@gmail.com")
                .typePassword("123")
                .pressLoginButton()
                .checkErrorMessage("Неверный логин или пароль.");
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