package pages;

import io.qameta.allure.Step;
import pages.components.FavoriteIconComponent;

import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.favoritePath;

public class FavoriteProductsPage {
    private final FavoriteIconComponent favorite = new FavoriteIconComponent();

    @Step("Открываем страницу favorites/")
    public FavoriteProductsPage openPage() {
        open(favoritePath);
        return this;
    }

    public FavoriteProductsPage checkFavoriteItem(String itemId) {
        favorite.checkThatProductIsfavorite(itemId);
        return this;
    }
}
