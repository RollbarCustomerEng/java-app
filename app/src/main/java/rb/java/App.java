/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rb.java;


/* 
import com.rollbar.notifier.Rollbar;
import java.util.HashMap;
import java.util.Map;
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger("rb.java");

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{

        LOGGER.error("Starting main method");

        Work w = new Work();
        w.doWorkTwo();
        System.out.println(new App().getGreeting());

        // TODO: Verify that app is configured to ensure last log messages complely send before exitting
        Thread.sleep(15000);
    }
}