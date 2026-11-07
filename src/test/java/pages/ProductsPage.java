package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    private final ElementsCollection listOfProducts = $$(".item.mn-card");

    @Step("Проверяем что открыта страница по запросу {query}")
    public ProductsPage checkProductQuery(String query){
        webdriver().driver().url().endsWith("catalog/?q=кофемашинка");
        return this;
    }
    @Step("Проверяем что список товаров не пустой")
    public void checkProductListNotEmpty(){
        listOfProducts.shouldHave(sizeGreaterThan(0));
    }
}
