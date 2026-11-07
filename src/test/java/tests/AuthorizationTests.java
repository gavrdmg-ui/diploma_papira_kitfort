package tests;

import org.junit.jupiter.api.Test;


public class AuthorizationTests extends BaseTest {

    @Test
    void successfulLoginTest() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail("rudenkoi528@gmail.com")
                .typePassword("aezakmi135")
                .pressLoginButton();

        accountPage.openPage()
                .checkEmail("rudenkoi528@gmail.com");
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

        mainPage.loginForm.typeEmail("rudenkoi528@gmail.com")
                .typePassword("aezakmi135")
                .pressLoginButton();

        accountPage.openPage()
                .logout()
                .openPage()
                .checkUserNotAuthorized();

    }
}