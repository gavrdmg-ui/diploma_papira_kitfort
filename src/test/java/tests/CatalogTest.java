package tests;

import org.junit.jupiter.api.Test;

public class CatalogTest extends BaseTest{

    @Test
    public void addNewItemToFavorite(){
        newProducts.openPage()
                .choseFirstProductAsFavorite()
                .openPage()
                .checkThatProductIsfavorite();

    }

    @Test
    public void checkThatNewProductExistOnFavoritePage(){
        newProducts.openPage()
                .choseFirstProductAsFavorite();
        favoriteProducts.openPage()
                .checkFavoriteItem(newProducts.getChosenItem());

    }
}
