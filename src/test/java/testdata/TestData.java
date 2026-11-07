package testdata;

import net.datafaker.Faker;

public class TestData {
    private final Faker faker = new Faker();
    public String newName=faker.name().firstName();
    public String newLastName=faker.name().lastName();
    public String newSecondName=faker.name().lastName();
    public String birthDate = String.valueOf(faker.number().numberBetween(10, 20))+ "."
            +String.valueOf(faker.number().numberBetween(10, 12))+"."
            +String.valueOf(faker.number().numberBetween(1936, 2026));
    public static String formError = "Неверный логин или пароль.";
    public static String invalidEmail = "email@gmail.com";
    public static String invalidPassword = "123";

}
