package tests;

import org.junit.jupiter.api.Test;

public class SearchProductTest extends BaseTest{

    @Test
    public void searchProduct(){
        mainPage.openPage()
                .typeSearch("кофемашинка")
                .makeSearch();
        productsPage.checkProductQuery("catalog/?q=кофемашинка")
                .checkProductListNotEmpty();
    }
}
