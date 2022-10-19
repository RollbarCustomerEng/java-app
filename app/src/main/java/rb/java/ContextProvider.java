package rb.java;

import java.util.HashMap;
import java.util.Map;

import com.rollbar.notifier.provider.Provider;

public class ContextProvider implements Provider<String>{

    public ContextProvider(){
    }


    @Override
    public String provide() {

        String persona = "request";
        return persona;
    }
    
}
