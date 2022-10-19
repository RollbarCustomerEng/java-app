/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rb.java;


import com.rollbar.notifier.Rollbar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger("rb.java");

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{

        RollbarConfig config = new RollbarConfig();
        Rollbar rollbar = config.rollbar();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("custom_field_1", "1234");
        map.put("custom_field_2", "5678");


        try{
            LOGGER.info("Starting main method");
            rollbar.info("Application has started");

            Work w = new Work();
            w.doWorkTwo();
            System.out.println(new App().getGreeting());

            throw new Exception(" Bad Error");
        }
        catch(Exception ex)
        {
            rollbar.error(ex,  map, "Fatal Error - Application exitting");
        }
        finally{
            // Force last occurrences of rollbar object to be completely sent before exitting
            rollbar.close(true);

            // Give time for all LOGGER occurrences to be completed before exitting
            // LOGGER batches occurrences
            Thread.sleep(16000);
        }
    }
}
