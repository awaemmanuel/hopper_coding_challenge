public class Solution {
    public static void main(String[] args) {
        String result = IntToStringConverter.convert(12345);
        System.out.println(result);

        /* Instantiate a time interpretation class */
        TimeInterpreter timeInterpreter = new TimeInterpreter(-1,-1);
        timeInterpreter.validateInput();
    }
}
