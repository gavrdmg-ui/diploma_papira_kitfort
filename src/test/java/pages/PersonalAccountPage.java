package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.LoginFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.profilePath;

public class PersonalAccountPage {

    private final SelenideElement email = $("[name=\"EMAIL\"]");
    private final SelenideElement lastNameInput = $("[name=\"LAST_NAME\"]");
    private final SelenideElement nameInput = $("[name=\"NAME\"]");
    private final SelenideElement secondNameInput = $("[name=\"SECOND_NAME\"]");
    private final SelenideElement personalBirthDateInput = $("[name=\"PERSONAL_BIRTHDAY\"]");
    private final SelenideElement saveButton = $("[value=\"Сохранить\"]");
    private final SelenideElement saveNotification = $(".notetext");
    private final SelenideElement exitButton = $(byText("Выйти"));
    LoginFormComponent loginForm = new LoginFormComponent();

    @Step("Открываем страницу personal/profile/")
    public PersonalAccountPage openPage() {
        open(profilePath);
        return this;
    }

    @Step("Проверяем что email соответствует значению {expectedEmail}")
    public PersonalAccountPage checkEmail(String expectedEmail) {
        email.shouldHave(value(expectedEmail));
        return this;
    }

    @Step("Проверяем что Имя соответствует значению {expectedName}")
    public PersonalAccountPage editName(String expectedName) {
        nameInput.setValue(expectedName);
        return this;
    }

    @Step("Проверяем что фамилия соответствует значению {expectedLastName}")
    public PersonalAccountPage editLastName(String expectedLastName) {
        lastNameInput.setValue(expectedLastName);
        return this;
    }

    @Step("Проверяем что отчество соответствует значению {expectedSecondName}")
    public PersonalAccountPage editSecondName(String expectedSecondName) {
        secondNameInput.setValue(expectedSecondName);
        return this;
    }

    @Step("Проверяем что дата рождения соответствует значению {expectedBirthDate}")
    public PersonalAccountPage editBirthDate(String expectedBirthDate) {
        personalBirthDateInput.setValue(expectedBirthDate);
        return this;
    }

    @Step("Нажимаем на кнопу \"Сохранить изменения\"")
    public PersonalAccountPage saveChanges() {
        saveButton.click();
        return this;
    }
    @Step("Проверяем наличие собщения \"Изменения сохранены\"")
    public PersonalAccountPage saveChangesMessageExist() {
        saveNotification.shouldBe(visible).shouldHave(text("Изменения сохранены"));
        return this;
    }

    @Step("Проверяем что данные в профиле соответствуют введенным ранее")
    public PersonalAccountPage checkPersonalData(String name, String lastName, String secondName, String birthdate) {
        nameInput.shouldHave(value(name));
        lastNameInput.shouldHave(value(lastName));
        secondNameInput.shouldHave(value(secondName));
        personalBirthDateInput.shouldHave(value(birthdate));
        return this;
    }

    @Step("Выходи из аккаунта")
    public PersonalAccountPage logout() {
        exitButton.click();
        return this;
    }

    @Step("Проверяем что при переход на страницу акаунта для неавторизованного пользователя отображается форма схода")
    public PersonalAccountPage checkUserNotAuthorized() {
        loginForm.emailFieldIsPresented();
        loginForm.passwordFieldIsPresented();
        return this;
    }


}
