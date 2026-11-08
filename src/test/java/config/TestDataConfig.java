package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:configurations/web/TestData.properties"
})
public interface TestDataConfig extends Config {

    @Key("user.validEmail")
    @DefaultValue("")
    String validEmail();

    @Key("user.validPassword")
    @DefaultValue("")
    String validPassword();

    @Key("searchQuery")
    @DefaultValue("кофемолка")
    String searchQuery();


}
