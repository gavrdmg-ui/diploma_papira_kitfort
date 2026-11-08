package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;

@DisplayName("Тесты на авторизацию")
public class AuthorizationTests extends BaseTest {
    @Test
    @DisplayName("Успешная авторизация и выход пользователя с сайта")
    void successfulLoginTest() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail(TestData.userEmail)
                .typePassword(TestData.userPassword)
                .pressLoginButton();

        accountPage.openPage()
                .checkEmail(TestData.userEmail)
                .logout()
                .openPage()
                .checkUserNotAuthorized();
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
}