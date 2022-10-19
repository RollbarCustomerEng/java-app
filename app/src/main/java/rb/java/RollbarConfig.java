package rb.java;

import java.util.HashMap;
import java.util.Map;

import com.rollbar.notifier.Rollbar;

import com.rollbar.notifier.config.Config;
import com.rollbar.notifier.config.ConfigBuilder;
import com.rollbar.notifier.config.ConfigProvider;
import com.rollbar.notifier.provider.server.ServerProvider;


public class RollbarConfig implements ConfigProvider {

  public Rollbar rollbar() {

    ConfigBuilder configBuilder = ConfigBuilder.withAccessToken("");
    Rollbar rollbar = new Rollbar(provide(configBuilder));
    rollbar.info("RollbarConfig completing");

    return rollbar;
  }


  @Override
  public Config provide(ConfigBuilder configBuilder) {

    String accessToken = System.getenv("rollbar_access_token");
    String environment = System.getenv("rollbar_environment");
    String codeVersion = System.getenv("rollbar_code_version");


    boolean enabled = true; // Easily enable/disable Rollbarin diff environments during implementation phase

    if(environment != "production"){
      enabled = false;
    }

    Config config =  ConfigBuilder.withAccessToken(accessToken)
        .enabled(enabled)
        .context(new ContextProvider())
        .environment(environment)
        .codeVersion(codeVersion)
        .custom(new CustomProvider())
        .transformer(new PayloadTransformer())
        .server(new ServerProvider())
        .request(new RequestProvider())
        .build();

    return config;
  }
}
