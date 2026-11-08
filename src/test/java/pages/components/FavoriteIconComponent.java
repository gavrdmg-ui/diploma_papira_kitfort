package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FavoriteIconComponent {

    private final SelenideElement addToFavoriteButton = $(".item__gallery-link .add_fav");

    @Step("Проверяем что продукт с id {chosenItem} выбран как избранный")
    public void checkThatProductIsFavorite(String chosenItem) {
        $x("//div[@data-id=\"" + chosenItem + "\"]").shouldHave(cssClass("in_fav"));
    }

    @Step("Проверяем что продукт с id {chosenItem} не выбран как избранный")
    public void checkThatProductIsNotFavorite(String chosenItem) {
        $x("//div[@data-id=\"" + chosenItem + "\"]").shouldNotHave(cssClass("in_fav"));
    }

    @Step("Нажимаем на кнопку добавления в избранное")
    public String clickFavoriteIcon() {
        try {
            Thread.sleep(1000);
            addToFavoriteButton.shouldBe(clickable);
            addToFavoriteButton.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return addToFavoriteButton.getAttribute("data-id");
    }

}
