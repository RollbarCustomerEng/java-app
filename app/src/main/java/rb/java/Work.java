package rb.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Work {

    private static final Logger LOGGER = LoggerFactory.getLogger("rb.java");

    public Work(){
    }

    public void doWorkTwo() throws Exception{
        LOGGER.info("Starting doWorkTwo");

        try {
            this.doTest(-10);
        }
        catch(IllegalArgumentException ex)
        {
            LOGGER.error("Illegal Argument Exception", ex);
        }
    }

    private void doTest(int val) throws IllegalArgumentException{

        if(val <= 0) {
            throw new IllegalArgumentException("Value must be greater than zero."); 
        }
    }
}
