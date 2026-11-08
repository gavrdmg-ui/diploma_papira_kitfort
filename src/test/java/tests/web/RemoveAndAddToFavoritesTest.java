package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты добавления и удаления товаров из избранного")
public class RemoveAndAddToFavoritesTest extends BaseTest {

    @Test
    @DisplayName("Добавление товара в избранное на экране товаров. Удаление товара из избранного")
    public void addAndRemoveNewProductToFavorite() {
        newProducts.openPage()
                .clickFavoriteButton()
                .openPage()
                .checkThatProductIsFavorite()
                .clickFavoriteButton()
                .openPage()
                .checkThatProductIsNotFavorite();
    }

    @Test
    @DisplayName("Добавление товара в избранное на экране товаров. Отображаение что товар добавлен в избранное на экране" +
            " избранных товаров")
    public void NewProductExistOnFavoritePage() {
        newProducts.openPage()
                .clickFavoriteButton();
        favoriteProducts.openPage()
                .checkFavoriteItem(newProducts.getChosenItem());
    }

    @Test
    @DisplayName("Добавление товара в избранное на экране товаров. Отображаение что товар добавлен в избранное на экране" +
            " избранных товаров. Удаление товара из избраного на экране избранных товаров")
    public void NewProductNotExistOnFavoritePageAfterUnfavorite() {
        newProducts.openPage()
                .clickFavoriteButton();
        favoriteProducts.openPage()
                .checkFavoriteItem(newProducts.getChosenItem());
        favoriteProducts.clickFavoriteButton()
                .openPage()
                .favoriteIsEmpty();

    }
}
