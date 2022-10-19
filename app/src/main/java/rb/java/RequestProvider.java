package rb.java;
import com.rollbar.api.payload.data.Request;
import com.rollbar.notifier.provider.Provider;

public class RequestProvider implements Provider<Request>{

    @Override
    public Request provide() {

        Request request = new Request.Builder()
          .userIp("127.0.0.1")
          .build();

          return request;
    }
}
