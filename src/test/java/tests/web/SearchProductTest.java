package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Тесты на поиск товаров")
public class SearchProductTest extends BaseTest {

    @CsvFileSource(resources = "/query.csv")
    @ParameterizedTest(name = "Поиск продукта {0}. Переход на страницу с найденными товарами\"")
    public void searchProduct(String query) {
        mainPage.openPage()
                .typeSearch(query)
                .makeSearch();
        productsPage.checkProductQuery(query)
                .checkProductListNotEmpty();

    }
}
