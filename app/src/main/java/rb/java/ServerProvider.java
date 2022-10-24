package rb.java;


import com.rollbar.notifier.provider.Provider;
import com.rollbar.api.payload.data.Server;

class ServerProvider implements Provider<Server> {

    //
    // A class to provide details about the server. Proper configuration is required to
    // ensure that:
    // The source control integration works as expected
    // It is clear when the same Item occurs in more than one environment
    // 
    // * code branch - if the code is not on the default code branch
    // * code version - if not already set at initialization
    // * host - The name of the server hosting the application
    // * root - parts of the file path
    //

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