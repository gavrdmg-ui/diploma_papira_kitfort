package tests;

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
                .editName("Иван")
                .editLastName("Иванов")
                .editSecondName("Иванович")
                .editBirthDate("27.09.2000")
                .saveChanges()
                .openPage()
                .checkPersonalData("Иван", "Иванов", "Иванович", "27.09.2000");
    }
}
