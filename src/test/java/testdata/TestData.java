package testdata;

import config.ConfigProvider;
import net.datafaker.Faker;

public class TestData {
    private final Faker faker = new Faker();
    public static final String favoritePath = "favorites/";
    public static final String newProductsPath = "new-items/";
    public static final String profilePath = "personal/profile/";

    public String newName = faker.name().firstName();
    public String newLastName = faker.name().lastName();
    public String newSecondName = faker.name().lastName();
    public String birthDate = String.valueOf(faker.number().numberBetween(10, 20)) + "."
            + String.valueOf(faker.number().numberBetween(10, 12)) + "."
            + String.valueOf(faker.number().numberBetween(1936, 2026));
    public static final String searchQuery = ConfigProvider.testDataConfig.searchQuery();
    public static final String userEmail = ConfigProvider.testDataConfig.validEmail();
    public static final String userPassword = ConfigProvider.testDataConfig.validPassword();


    public static String formError = "Неверный логин или пароль.";
    public static String invalidEmail = "email@gmail.com";
    public static String invalidPassword = "123";

}
