package pages;

import io.qameta.allure.Step;
import pages.components.FavoriteIconComponent;

import static com.codeborne.selenide.Selenide.open;

public class FavoriteProductsPage {
    private FavoriteIconComponent favorite = new FavoriteIconComponent();

    @Step("Открываем страницу favorites/")
    public FavoriteProductsPage openPage(){
        open("favorites/");
        return this;
    }

    public FavoriteProductsPage checkFavoriteItem(String itemId){
        favorite.checkThatProductIsfavorite(itemId);
        return this;
    }
}
