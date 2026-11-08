package tests.web;

import config.ConfigProvider;
import org.junit.jupiter.api.Test;

public class EditProfileTest extends BaseTest {

    @Test
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
