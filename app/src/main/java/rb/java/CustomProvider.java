package rb.java;

import java.util.HashMap;
import java.util.Map;

import com.rollbar.notifier.provider.Provider;

public class CustomProvider implements Provider<Map<String, Object>>{

    public CustomProvider(){
    }


    @Override
    public Map<String, Object> provide() {

        // Fields that you want added to every error send to Rollbar
        Map customFields = new HashMap<String, Object>();
        customFields.put("cluster_id", "12345");
        customFields.put("ip_address", "127.0.0.2");

        return customFields;
    }
    
}
