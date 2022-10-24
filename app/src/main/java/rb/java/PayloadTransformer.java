package rb.java;

import java.util.Map;
import com.rollbar.api.payload.data.Data;
import com.rollbar.notifier.transformer.Transformer;

import com.rollbar.api.payload.data.Request;

import java.util.HashMap;

public class PayloadTransformer implements Transformer {

  //
  // A class used to do advanced modificication of the 
  // occurrence payload before the payload gets sent to 
  // api.rollbar.com
  //
  // Often used to do advanced data scrubbing or to add/remove data 
  // from the occurrence payload
  // 

    @Override
    public Data transform(Data data) {

      Data newData = data;

      // Do advanced data scrubbing of parts of the payload e.g. data.getBody().

      // Create a Custom object if the payload does not have any custom data
      Map<String,Object> map = newData.getCustom();
      if(map == null) {
        map = new HashMap<String, Object>();
      }
      
      // Add additional data fields. See also CustomProvider.java
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