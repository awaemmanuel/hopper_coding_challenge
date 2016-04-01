public class Solution {
    public static void main(String[] args) {
        String result = IntToStringConverter.convert(01);
        System.out.println(result);

        /* Instantiate a time interpretation class */
        TimeInterpreter timeInterpreter = new TimeInterpreter(23, 59);
        timeInterpreter.validateInput();
        System.out.println(timeInterpreter.get_hour());
        System.out.println(timeInterpreter.translate());


    }

}
