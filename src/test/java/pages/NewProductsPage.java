package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.FavoriteIconComponent;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.newProductsPath;

public class NewProductsPage {
    private final FavoriteIconComponent favorite = new FavoriteIconComponent();
    private final SelenideElement addToFavoriteButton = $(".item__gallery-link .add_fav");
    private String chosenItem;

    @Step("Открываем страницу new-items/")
    public NewProductsPage openPage() {
        open(newProductsPath);
        return this;
    }

    @Step("Добавляем первый товар в избранное")
    public NewProductsPage choseFirstProductAsFavorite() {
        try {
            Thread.sleep(1000);
            addToFavoriteButton.shouldBe(clickable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        addToFavoriteButton.click();
        chosenItem = addToFavoriteButton.getAttribute("data-id");
        return this;
    }

    @Step("Проверяем что товар добален в избранное")
    public NewProductsPage checkThatProductIsfavorite() {
        favorite.checkThatProductIsfavorite(chosenItem);
        return this;
    }

    public String getChosenItem() {
        return chosenItem;
    }
}
