package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты работы с каталогом товаров")
public class CatalogTest extends BaseTest {

    @Test
    @DisplayName("Добавление товара в избранное на экране товаров. Отображаение что товар добавлен в избранное на экране" +
            " товаров")
    public void addNewItemToFavorite() {
        newProducts.openPage()
                .choseFirstProductAsFavorite()
                .openPage()
                .checkThatProductIsfavorite();

    }

    @Test
    @DisplayName("Добавление товара в избранное на экране товаров. Отображаение что товар добавлен в избранное на экране" +
            " избранных товаров")
    public void checkThatNewProductExistOnFavoritePage() {
        newProducts.openPage()
                .choseFirstProductAsFavorite();
        favoriteProducts.openPage()
                .checkFavoriteItem(newProducts.getChosenItem());

    }
}
