package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsPage {

    private final ElementsCollection listOfProducts = $$(".item.mn-card");

    @Step("Проверяем что открыта страница по запросу {query}")
    public ProductsPage checkProductQuery(String query) {
        String decodedUrl = URLDecoder.decode(url(), StandardCharsets.UTF_8);
        assertEquals(true, decodedUrl.endsWith("/catalog/?q="+query));
        return this;
    }

    @Step("Проверяем что список товаров не пустой")
    public void checkProductListNotEmpty() {
        listOfProducts.shouldHave(sizeGreaterThan(0));
    }
}
