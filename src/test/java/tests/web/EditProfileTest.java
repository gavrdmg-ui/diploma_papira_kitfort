package tests.web;

import config.ConfigProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты на редактирование профиля пользователя")
public class EditProfileTest extends BaseTest {

    @Test
    @DisplayName("Редактирование данных пользователя. Проверка что данные изменились")
    public void editUserInformation() {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail(ConfigProvider.testDataConfig.validEmail())
                .typePassword(ConfigProvider.testDataConfig.validPassword())
                .pressLoginButton();

        accountPage.openPage()
                .editName(testData.newName)
                .editLastName(testData.newLastName)
                .editSecondName(testData.newSecondName)
                .editBirthDate(testData.birthDate)
                .saveChanges()
                .saveChangesMessageExist()
                .openPage()
                .checkPersonalData(testData.newName, testData.newLastName, testData.newSecondName, testData.birthDate);
    }
}
