package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static final WebUIConfig webConfig =
            ConfigFactory.create(WebUIConfig.class, System.getProperties());

    public static final TestDataConfig testDataConfig =
            ConfigFactory.create(TestDataConfig.class, System.getProperties());

}
