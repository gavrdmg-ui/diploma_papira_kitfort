package tests.web;

import com.codeborne.selenide.Configuration;
import config.ConfigProvider;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import testdata.TestData;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {
    MainPage mainPage = new MainPage();
    PersonalAccountPage accountPage = new PersonalAccountPage();
    NewProductsPage newProducts = new NewProductsPage();
    FavoriteProductsPage favoriteProducts = new FavoriteProductsPage();
    ProductsPage productsPage = new ProductsPage();
    public static TestData testData;

    @BeforeAll
    static void setup() {
        testData = new TestData();
        Configuration.browser = ConfigProvider.webConfig.browser();
        Configuration.browserVersion = ConfigProvider.webConfig.browserVersion();
        Configuration.browserSize = ConfigProvider.webConfig.browserSize();
        Configuration.headless = ConfigProvider.webConfig.headless();
        Configuration.holdBrowserOpen = ConfigProvider.webConfig.holdBrowserOpen();
        Configuration.baseUrl = ConfigProvider.webConfig.baseUrl();
        //Configuration.remote = System.getProperty("remoteURL","https://user1:1234@selenoid.qa.guru/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(List.of("--disable-dev-shm-usage", "--no-sandbox"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.attachAsText("Some file", "Some content");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}