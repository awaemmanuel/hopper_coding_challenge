public class Solution {
    public static void main(String[] args) {
        String result = IntToStringConverter.convert(01);
        System.out.println(result);

        /* Instantiate a time interpretation class */
        TimeInterpreter timeInterpreter = new TimeInterpreter(24.456, 898);
        timeInterpreter.validateInput();

    }

}
