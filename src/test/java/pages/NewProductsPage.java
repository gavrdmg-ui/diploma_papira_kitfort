package pages;

import io.qameta.allure.Step;
import pages.components.FavoriteIconComponent;

import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.newProductsPath;

public class NewProductsPage {
    private final FavoriteIconComponent favorite = new FavoriteIconComponent();
    private String chosenItem;

    @Step("Открываем страницу new-items/")
    public NewProductsPage openPage() {
        open(newProductsPath);
        return this;
    }

    public NewProductsPage clickFavoriteButton() {
        chosenItem = favorite.clickFavoriteIcon();
        return this;
    }

    @Step("Проверяем что товар добален в избранное")
    public NewProductsPage checkThatProductIsFavorite() {
        favorite.checkThatProductIsFavorite(chosenItem);
        return this;
    }

    @Step("Проверяем что товар не добавлен в избранное")
    public NewProductsPage checkThatProductIsNotFavorite() {
        favorite.checkThatProductIsNotFavorite(chosenItem);
        return this;
    }

    public String getChosenItem() {
        return chosenItem;
    }
}
