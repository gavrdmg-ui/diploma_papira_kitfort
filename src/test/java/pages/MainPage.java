package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.LoginFormComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement loginButton = $("#auth_modal_link");
    private final SelenideElement searchInput = $("#smart-title-search-input");
    private final SelenideElement searchButton = $(".search__button");

    public LoginFormComponent loginForm = new LoginFormComponent();

    @Step("Открываем страницу kitfort.ru")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Открываем окно для входа")
    public MainPage openLoginForm() {
        loginButton.click();
        return this;
    }

    @Step("Вводим в поле поиска запрос {searchQuery}")
    public MainPage typeSearch(String searchQuery) {
        searchInput.setValue(searchQuery);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public MainPage makeSearch() {
        searchButton.click();
        return this;
    }

}
