public class Solution {
    public static void main(String[] args) {


        /*
        *
        * TESTS
        * - 1. Validate Constructor overloading
        * - 2. Validate different inputs
        * - 3. Validate 24hr format
        * - 4. Validate wrong format
        */

        TimeInterpreter timeInterpreter;

        // Validate constructor overloading with strings
        timeInterpreter = new TimeInterpreter("4", "59");
        timeInterpreter.validateAndDisplay();

        // Validate constructor overloading with floating point numbers
        timeInterpreter = new TimeInterpreter(5.009, 0.999);
        timeInterpreter.validateAndDisplay();

        // Validate constructor overloading with integers
        timeInterpreter = new TimeInterpreter(5, 01);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 10);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 15);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 30);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 40);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 45);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 47);
        timeInterpreter.validateAndDisplay();

        timeInterpreter = new TimeInterpreter(5, 28);
        timeInterpreter.validateAndDisplay();
        /*
        // Validate wrong inputs
        timeInterpreter = new TimeInterpreter(-5, -28);
        timeInterpreter.validateAndDisplay();


        // Validate wrong input for String constructor - Commented out to test other and avoid exceptions. Uncomment to test.
        timeInterpreter = new TimeInterpreter("5.009", "0.999");
        timeInterpreter.validateAndDisplay();
        */
    }
}
