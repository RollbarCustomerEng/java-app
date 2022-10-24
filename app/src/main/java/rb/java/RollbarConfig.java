package rb.java;

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

    // Read important settings from environment variables/config file
    String accessToken = System.getenv("rollbar_access_token");
    String environment = System.getenv("rollbar_environment");
    String codeVersion = System.getenv("rollbar_code_version");

    // Easily enable/disable Rollbar in different environments during implementation phase
    boolean enabled = true;

    // See each provider/transformer class for more details
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
