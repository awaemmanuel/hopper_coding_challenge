import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import junit.framework.TestCase;
//import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by Emmanuel Awa on 4/1/16.
 * Sample Unit tests for functions in module
 */
public class TimeInterpreterTest {
    @Test
    public void TestvalidateAndDisplay() {
        TimeInterpreter timeInterpreter = new TimeInterpreter("4", "59");
        assertEquals("One minute to five  AM.\n", timeInterpreter.unitTestInterpretation());

        // Validate constructor overloading with floating point numbers
        timeInterpreter = new TimeInterpreter(5.009, 0.999);
        assertEquals("Five o' clock AM.\n", timeInterpreter.unitTestInterpretation());

        // Validate constructor overloading with integers
        timeInterpreter = new TimeInterpreter(5, 01);
        assertEquals("One minute past five  AM.\n", timeInterpreter.unitTestInterpretation());

        timeInterpreter = new TimeInterpreter(5, 10);
        assertEquals("Ten minutes past five  AM.\n", timeInterpreter.unitTestInterpretation());
        
        timeInterpreter = new TimeInterpreter(5, 15);
        assertEquals("Quarter past five  AM.\n", timeInterpreter.unitTestInterpretation());
        
        timeInterpreter = new TimeInterpreter(5, 30);
        assertEquals("Half past five  AM.\n", timeInterpreter.unitTestInterpretation());
        
        timeInterpreter = new TimeInterpreter(5, 40);
        assertEquals("Twenty minutes to six  AM.\n", timeInterpreter.unitTestInterpretation());
        
        timeInterpreter = new TimeInterpreter(5, 45);
        assertEquals("Quarter to six  AM.\n", timeInterpreter.unitTestInterpretation());
        
        timeInterpreter = new TimeInterpreter(5, 47);
        assertEquals("Thirteen minutes to six  AM.\n", timeInterpreter.unitTestInterpretation());
        
        timeInterpreter = new TimeInterpreter(5, 28);
        assertEquals("Twenty eight minutes past five  AM.\n", timeInterpreter.unitTestInterpretation());
    }

}