package rb.java;

import java.util.HashMap;
import java.util.Map;

import com.rollbar.notifier.provider.Provider;

public class CustomProvider implements Provider<Map<String, Object>>{

    //
    // A class that adds a hashmap of key/value pairs
    // as custom fileds to the occurrence payload
    //

    public CustomProvider(){
    }


    @Override
    public Map<String, Object> provide() {

        //
        // Fields that you want added to every occurrence sent to Rollbar
        //
        Map customFields = new HashMap<String, Object>();
        customFields.put("cluster_id", "12345");

        return customFields;
    }
    
}
