package tests.web;

import config.ConfigProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;

@DisplayName("Тесты на авторизацию")
public class AuthorizationTests extends BaseTest {
    @Test
    @DisplayName("Успешная авторизация пользователя")
    void successfulLoginTest() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail(TestData.userEmail)
                .typePassword(TestData.userPassword)
                .pressLoginButton();

        accountPage.openPage()
                .checkEmail(TestData.userEmail);
    }

    @Test
    @DisplayName("Авторизация с невалидными логином и паролем")
    void loginWithWrongCredentials() {
        mainPage.openPage()
                .openLoginForm();
        mainPage.loginForm.typeEmail(TestData.invalidEmail)
                .typePassword(TestData.invalidPassword)
                .pressLoginButton()
                .checkErrorMessage(TestData.formError);
    }

    @Test
    @DisplayName("Успешный выход пользователя из системы")
    void successfulLogOut() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail(TestData.userEmail)
                .typePassword(TestData.userPassword)
                .pressLoginButton();

        accountPage.openPage()
                .logout()
                .openPage()
                .checkUserNotAuthorized();

    }
}