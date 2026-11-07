package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configurations/WebUIConfig.properties"
})
public interface WebUIConfig extends Config {


    @DefaultValue("chrome")
    String browser();

    @DefaultValue("156")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("false")
    boolean headless();

    @DefaultValue("false")
    boolean holdBrowserOpen();

    @DefaultValue("https://kitfort.ru/")
    String baseUrl();
}
