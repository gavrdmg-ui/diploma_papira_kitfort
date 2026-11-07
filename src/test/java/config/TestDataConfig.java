package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configurations/TestData.properties"
})
public interface TestDataConfig extends Config {

    @Key("user.validEmail")
    @DefaultValue("https://lknew.ch-sk.ru")
    String validEmail();

    @Key("user.validPassword")
    @DefaultValue("https://lknew.ch-sk.ru")
    String validPassword();

}
