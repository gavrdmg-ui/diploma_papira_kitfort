package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configurations/WebUIConfig.properties"
})
public interface WebUIConfig extends Config {
    String browser();

    String browserVersion();

    String browserSize();

    boolean  headless();

    boolean  holdBrowserOpen();

    String baseUrl();
}
