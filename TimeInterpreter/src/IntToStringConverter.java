/**
 * Created by Emmanuel Awa on 3/31/16.
 * A generalized class that can convert a digit/number
 * to its string representation.
 */
public class IntToStringConverter {
    /* String array for digit to word representation
    *  - digit serves as index into array for O(1) lookup
    * */
    private int _number;
    private static final String[] _units = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };
    private static final String[] _teens = {
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    private static final String[] _tens = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] _higher = {
            "hundred",
            "thousand",
            "million",
            "billion",
            "trillion",
            "quadrillion",
            "quintillion",
            "sextillion",
            "septillion",
            "octillion",
            "nonillion",
            "decillion"
    };
    public IntToStringConverter(int number) {

        _number = number;
    }

    /* Convert digit to string representation */
    public static String convert(int digits) {
        // hold result with a dynamic string array
        StringBuilder result = new StringBuilder();

        String stringDigits, temp = "";
        stringDigits = Integer.toString(digits);

        int i = stringDigits.length() - 1, word;
        boolean showThousands;
        boolean allZeros = true;

        while (i >= 0) {
            int ndigit = (int)(stringDigits.charAt(i) - '0');
            int column = (stringDigits.length() - (i + 1));

            // Determine if units, tens, or hundreds column
            switch (column % 3)
            {
                case 0:        // Ones position
                    showThousands = true;
                    if (i == 0)
                    {
                        // First digit in number (last in loop)
                        temp = String.format("%s ", _units[ndigit]);
                    }
                    else if (stringDigits.charAt(i - 1) == '1')
                    {
                        // This digit is part of "teen" value
                        temp = String.format("%s ",_teens[ndigit]);

                        // Skip tens position
                        i--;
                    }
                    else if (ndigit != 0)
                    {
                        // Any non-zero digit
                        temp = String.format("%s ", _units[ndigit]);

                    }
                    else
                    {
                        // This digit is zero. If digit in tens and hundreds
                        // column are also zero, don't show "thousands"

                        // Test for non-zero digit in this grouping
                        showThousands = stringDigits.charAt(i - 1) != '0'
                                || (i > 1 && stringDigits.charAt(i - 2) != '0');
                    }

                    // Show "thousands" if non-zero in grouping
                    if (showThousands)
                    {
                        if (column > 0)
                        {
                            temp = String.format("%s%s%s",
                                    temp,
                                    _higher[column / 3],
                                    allZeros ? " " : ", ");
                        }
                        // Indicate non-zero digit encountered
                        allZeros = false;
                    }
                    result.insert(0, temp);
                    break;

                case 1:        // Tens column
                    if (ndigit > 0)
                    {
                        temp = String.format("%s%s",
                                _tens[ndigit],
                                (stringDigits.charAt(i + 1) != '0') ? "-" : " ");
                        result.insert(0, temp);
                    }
                    break;

                case 2:        // Hundreds column
                    if (ndigit > 0)
                    {
                        temp = String.format("%s hundred ", _units[ndigit]);
                        result.insert(0, temp);
                    }
                    break;
            }
            i -= 1;
        }
        return String.format("%s%s", result.substring(0,1).toUpperCase(), result.substring(1));
    }

    /* Getters */

    public static String get_higher(int index) {
        return _higher[index];
    }

    public static String get_tens(int index) {
        return _tens[index];
    }

    public static String get_teens(int index) {
        return _teens[index];
    }

    public static String get_units(int index) {
        return _units[index];
    }
}
