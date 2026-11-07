package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$x;

public class FavoriteIconComponent {

    @Step("Проверяем что продукт с id {chosenItem} выбран как избранный")
    public void checkThatProductIsfavorite(String chosenItem) {
        $x("//div[@data-id=\"" + chosenItem + "\"]").shouldHave(cssClass("in_fav"));
    }
}
