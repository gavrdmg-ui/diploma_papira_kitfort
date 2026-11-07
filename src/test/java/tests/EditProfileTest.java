package tests;

import org.junit.jupiter.api.Test;

public class EditProfileTest extends BaseTest{

    @Test
    public void editUserInformation()
    {
        mainPage.openPage()
                .openLoginForm();

        mainPage.loginForm.typeEmail("rudenkoi528@gmail.com")
                .typePassword("aezakmi135")
                .pressLoginButton();

        accountPage.openPage()
                .editName("Иван")
                .editLastName("Иванов")
                .editSecondName("Иванович")
                .editBirthDate("27.09.2000")
                .saveChanges()
                .openPage()
                .checkPersonalData("Иван","Иванов","Иванович","27.09.2000");
    }
}
