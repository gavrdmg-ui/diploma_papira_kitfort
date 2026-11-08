package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты на поиск товаров")
public class SearchProductTest extends BaseTest {

    @Test
    @DisplayName("Поиск продукта. Переход на страницу с найденными товарами")
    public void searchProduct() {
        mainPage.openPage()
                .typeSearch("кофемашинка")
                .makeSearch();
        productsPage.checkProductQuery("catalog/?q=кофемашинка")
                .checkProductListNotEmpty();
    }
}
