package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.FavoriteIconComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.favoritePath;

public class FavoriteProductsPage {
    private final FavoriteIconComponent favorite = new FavoriteIconComponent();
    private final SelenideElement emptyFavoriteBlock = $(".empty_fav_block");

    @Step("Открываем страницу favorites/")
    public FavoriteProductsPage openPage() {
        open(favoritePath);
        return this;
    }

    public FavoriteProductsPage checkFavoriteItem(String itemId) {
        favorite.checkThatProductIsFavorite(itemId);
        return this;
    }

    public FavoriteProductsPage clickFavoriteButton() {
        favorite.clickFavoriteIcon();
        return this;
    }

    @Step("Проверяем что список избранного пуст")
    public FavoriteProductsPage favoriteIsEmpty() {
        emptyFavoriteBlock.shouldBe(visible);
        return this;
    }


}
