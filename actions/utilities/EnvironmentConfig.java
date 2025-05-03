package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:envConfig/${environment}"})
public interface EnvironmentConfig extends Config {
    String url();
    @Key("App.url")
    String getAppUrl();

    @Key("App.username")
    String getAppUsername();

    @Key("App.password")
    String getAppPassword();
}
