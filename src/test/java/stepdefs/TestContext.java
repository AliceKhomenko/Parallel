package stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by khomenkoalina on 04.12.19.
 */
public class TestContext {
    private static final Map<String, Object> sharedVariables = new HashMap<>();
    //private static final Logger logger = LoggerFactory.getLogger(TestContext.class);


    public static Object getSharedVariable(String key) {

        return sharedVariables.get(key);
    }

    public static void setSharedVariable(String key, Object value) {

        System.out.println("I use "+key+" with value="+value);
        sharedVariables.put(key, value);
    }

    public static String printSharedVariables(){
        return sharedVariables.toString();

    }

    public static int getSize(){
        return  sharedVariables.size();

    }

    public static void clearTestVariables(){
        sharedVariables.clear();

    }

}
