package rb.java;

import java.util.HashMap;
import java.util.Map;

import com.rollbar.notifier.provider.Provider;

public class ContextProvider implements Provider<String>{

    //
    // A class to set the context property
    // The context property is a field that:
    // Can be used to filter items in the items view. 
    // It is an indexed fields in RQL queries
    // It is available for filtering and aggregation in the Rollbar Metrics API
    // It can be used in Notification logic when Notifying Slack, PagerDuty, Webhook etc.
    //
    // See also:
    // https://docs.rollbar.com/docs/search-items#context
    // https://docs.rollbar.com/docs/notifications
    // https://docs.rollbar.com/docs/rql
    //

    public ContextProvider(){
    }


    @Override
    public String provide() {

        String context = "web-request";
        return context;
    }
    
}
