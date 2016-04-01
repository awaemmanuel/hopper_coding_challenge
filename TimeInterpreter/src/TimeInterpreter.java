public class TimeInterpreter {
    private int _hour, _minute;
    private boolean _isTimePM = false;
    private static final int ZERO_MINUTE = 0;
    private static final int ONE_MINUTE = 1;
    private static final int FIFTEEN_MINUTES = 15;
    private static final int THIRTY_MINUTES = 30;
    private static final int FORTYFIVE_MINUTES = 45;
    private static final int FIFTYNINE_MINUTES = 59;
    private static final int TWELVE_HOURS = 12;
    private static final double NEAREST_HOUR_ROUNDER = 0.5;


    /* Overloaded constructors */
    public TimeInterpreter(int hour, int minute) {
        set_hour(hour);
        set_minute(minute);
        if (get_hour() > TWELVE_HOURS) set_isTimePM(true);
    }
    public TimeInterpreter(double hour, double minute) {
        // Round to closest hour
        set_hour((int) (hour + NEAREST_HOUR_ROUNDER));
        set_minute((int)(minute));
        if (get_hour() > TWELVE_HOURS) set_isTimePM(true);
    }
    public TimeInterpreter(String hour, String minute) {
        try {
            set_hour(Integer.parseInt(hour));
            set_minute(Integer.parseInt(minute));
            if (get_hour() > TWELVE_HOURS) set_isTimePM(true);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("[BAD NUMBER FORMAT] - Float not allowed in String constructor. " +
                    "You can use plain float constructor to instantiate instead");
        }

    }

    /***************************************************
    * Main translation module.                         *
    * Converts the validated hour and minute,          *
    * generates the time in words and returns string   *
    ****************************************************/
    private String translate() {
        try{
            this.validateInput();
        }
        catch (AssertionError e) {
            throw new AssertionError("[INPUT ERROR] - Please check your input.");
        }

        StringBuilder translation = new StringBuilder();
        String minuteString, hour, minute;
        int minuteDifference = ZERO_MINUTE,
                inputMin = get_minute(),
                inputHr = get_hour();

        // Flags for edge cases
        boolean halfPast, quarterPast, quarterTo, topOfTheHour, notEdgeTime, pastThirty = false;
        halfPast = (inputMin == THIRTY_MINUTES);
        quarterPast = (inputMin == FIFTEEN_MINUTES);
        quarterTo = (inputMin == FORTYFIVE_MINUTES);
        topOfTheHour = (inputMin == ZERO_MINUTE);
        notEdgeTime = !(halfPast || quarterPast || quarterTo || topOfTheHour);

        // Get the right values of time to convert to string based on location of hands on the clock
        // Minute is in second half of hour - TO area
        if (notEdgeTime && inputMin > THIRTY_MINUTES && inputMin <= FIFTYNINE_MINUTES) {
            inputMin = (FIFTYNINE_MINUTES + ONE_MINUTE) - inputMin;
            inputHr += 1;
            pastThirty = true;
        }
        if (quarterTo) {
            inputHr += 1;
        }

        /*
        * Do translation of hour and string that we have now
        Convert hour and minute to string representations.
        */
        hour = IntToStringConverter.convert(inputHr);
        minute = IntToStringConverter.convert(inputMin);
        minuteString = inputMin > ONE_MINUTE ? "minutes " : "minute ";
        
        // For edge cases (quarters/half) make sure the minute string is translated accordingly
        if (notEdgeTime) {
            String direction = pastThirty ? "to " : "past ";
            translation.append(minute + minuteString + direction + hour.toLowerCase());
        }
        // Top of hour, quarter (past/to), half past cases
        else {
            String outputFormatter = "";
            if (topOfTheHour) {
                outputFormatter = inputHr == 0 ? "It's MIDNIGHT!" :  hour + "o' clock";
            }
            if (quarterPast) {
                outputFormatter = inputHr == 0 ? "Quarter past midnight" : "Quarter past " + hour.toLowerCase();
            }
            if (quarterTo) {
                outputFormatter = inputHr == 0 ? "Quarter to midnight" : "Quarter to " + hour.toLowerCase();
            }
            if (halfPast) {
                outputFormatter = inputHr == 0 ? "Half past midnight" : "Half past " + hour.toLowerCase();
            }
            translation.append(outputFormatter);
        }

        // Check if it is AM or PM at this point
        if (isTimePM()) {
            translation.append(" PM.\n");
        }
        else {
            translation.append(" AM.\n");
        }

        // Return translated result
        return translation.toString();
    }

    // Display result
    private void display(){
        System.out.format(translate());
        System.out.flush();
    }

    /* All input validations go here
     * 1. Validate the time range of input
      * 2. Ensure the input format of input (AM or PM) */
    private void validateInput() throws AssertionError {
        /* Ensure number in normal time range */
        if ((this._hour < 0) || (this._hour > 23)) throw new AssertionError("[TIME RANGE ERROR] - Allowed Hour range is 0-23");
        if ((this._minute < 0) || (this._minute > 59)) throw new AssertionError("[TIME RANGE ERROR] - Allowed Minute range is 0-59");

        /* If in the PM, normalize hour */
        if (isTimePM()) set_hour(this._hour % 12);
    }

    // Call validate and display to avoid two function calls from client side
    public void validateAndDisplay() {
        validateInput();
        display();
    }

    /* Getters and Setters */
    public int get_hour() {
        return _hour;
    }

    public void set_hour(int hour) {
        this._hour = hour;
    }

    public int get_minute() {
        return _minute;
    }

    public void set_minute(int minute) {
        this._minute = minute;
    }

    public boolean isTimePM() {
        return _isTimePM;
    }

    public void set_isTimePM(boolean isAMorPM) {
        this._isTimePM = isAMorPM;
    }
}
