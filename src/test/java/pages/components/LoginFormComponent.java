package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginFormComponent {
    private final SelenideElement emailInput = $("[name=\"USER_LOGIN\"]");
    private final SelenideElement passwordInput = $("[name=\"USER_PASSWORD\"]");
    private final SelenideElement loginButton = $("[name=\"Login\"]");
    private final SelenideElement errorMessage = $(".errortext");


    @Step("Заполняем поле E-mail")
    public LoginFormComponent typeEmail(String email){
        emailInput.setValue(email);
        return this;
    }
    @Step("Заполняем поле Пароль")
    public LoginFormComponent typePassword(String password){
        passwordInput.setValue(password);
        return this;
    }
    @Step("Нажимаем на кнопку \"Войти\"")
    public LoginFormComponent pressLoginButton(){
        loginButton.shouldBe(clickable);
        loginButton.click();
        return this;
    }
    @Step("Проверяем что текст ошибки соответствует {expectedErrorMessage}")
    public LoginFormComponent checkErrorMessage(String expectedErrorMessage){
        errorMessage.shouldHave(text(expectedErrorMessage));
        return this;
    }
    @Step("Проверяем что поле E-mail отображается")
    public LoginFormComponent emailFieldIsPresented(){
        emailInput.shouldHave(visible);
        return this;
    }
    @Step("Проверяем что поле Пароль отображается")
    public LoginFormComponent passwordFieldIsPresented(){
        passwordInput.shouldHave(visible);
        return this;
    }

}
