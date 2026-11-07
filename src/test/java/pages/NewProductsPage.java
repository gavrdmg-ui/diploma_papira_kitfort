package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.FavoriteIconComponent;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NewProductsPage{
    private FavoriteIconComponent favorite = new FavoriteIconComponent();
    private final SelenideElement listOfProducts = $("#catalog-section");
    private final SelenideElement addToFavoriteButton=$(".item__gallery-link .add_fav");
    private String chosenItem;

    @Step("Открываем страницу new-items/")
    public NewProductsPage openPage(){
        open("new-items/");
        return this;
    }

    @Step("Добавляем первый товар в избранное")
    public NewProductsPage choseFirstProductAsFavorite(){
        addToFavoriteButton.shouldBe(clickable);
        addToFavoriteButton.click();
        chosenItem = addToFavoriteButton.getAttribute("data-id");
        return this;
    }

    @Step("Проверяем что товар добален в избранное")
    public NewProductsPage checkThatProductIsfavorite(){
        favorite.checkThatProductIsfavorite(chosenItem);
        return this;
    }


    public String getChosenItem() {
        return chosenItem;
    }
}
