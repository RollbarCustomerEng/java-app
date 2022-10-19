package rb;


import com.rollbar.notifier.provider.Provider;
import com.rollbar.api.payload.data.Server;

class ServerProvider implements Provider<Server> {

    @Override
    public Server provide() {
 
        Server server =  new Server.Builder()
            .branch("main")
            .codeVersion("1.0.0")
            .host("server-1") // I assume you can put an IP address in here also
            .root("/approot/app")  // The part of the stack trace file paths not in the github repository
            .build();

        return server;

    }
}