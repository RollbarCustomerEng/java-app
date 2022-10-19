package rb.java;

import java.util.Map;
import com.rollbar.api.payload.data.Data;
import com.rollbar.notifier.transformer.Transformer;

import com.rollbar.api.payload.data.Request;

import java.util.HashMap;

public class PayloadTransformer implements Transformer {


    @Override
    public Data transform(Data data) {

      Data newData = data;

      // Do advanced data scrubbing of parts of the payload e.g. data.getBody().

      // create a new Hashmap for custom data
      // if no custom data is in the payload
      Map<String,Object> map = newData.getCustom();
      if(map == null) {
        map = new HashMap<String, Object>();
      }
      
      // add a custom field in the transform method
      map.put("customer_id", "cust_6789");
      map.put("request_id", "req_1234567890");

      map.put("session_id", "87ea3425672");


      newData = new Data.Builder(newData)
                        .custom(map)
                        .server(null)
                        .build();


          
      
      return newData;
    }
  }