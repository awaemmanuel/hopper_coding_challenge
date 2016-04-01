public class TimeInterpreter {
    private int _hour, _minute;
    private boolean _isTimePM;
    private static final int ZERO_MINUTE = 0;
    private static final int ONE_MINUTE = 1;
    private static final int FIFTEEN_MINUTES = 15;
    private static final int THIRTY_MINUTES = 30;
    private static final int FORTYFIVE_MINUTES = 45;
    public static final int FIFTYNINE_MINUTES = 59;
    private static final int TWELVE_HOURS = 12;
    private static final double NEAREST_HOUR_ROUNDER = 0.5;


    /* Overloaded constructors */
    public TimeInterpreter(int hour, int minute) {
        this._hour = hour;
        this._minute = minute;
        if (this._hour > TWELVE_HOURS) this._isTimePM = true;
    }
    public TimeInterpreter(double hour, double minute) {
        // Round to closest hour
        this._hour = (int) (hour + NEAREST_HOUR_ROUNDER);
        this._minute = (int) (minute);
        if (this._hour > TWELVE_HOURS) this._isTimePM = true;
    }
    public TimeInterpreter(String hour, String minute) {
        try {
            this._hour = Integer.parseInt(hour);
            this._minute = Integer.parseInt(minute);
            if (this._hour > TWELVE_HOURS) this._isTimePM = true;
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("[BAD NUMBER FORMAT] - Float not allowed. You can use plain float to instantiate instead");
        }

    }

    /***************************************************
    * Main translation module.                         *
    * Converts the validated hour and minute,          *
    * generates the time in words and returns string   *
    ****************************************************/
    public String translate() {
        StringBuilder translation = new StringBuilder();
        String minuteString;
        int minuteDifference = ZERO_MINUTE,
                inputMin = get_minute(),
                inputHr = get_hour();

        // Flags for edge cases
        boolean halfPast, quarterPast, quarterTo, topOfTheHour, notEdgeTime, pastThirty;
        halfPast = inputMin == THIRTY_MINUTES;
        quarterPast = inputMin == FIFTEEN_MINUTES;
        quarterTo = inputMin == FORTYFIVE_MINUTES;
        topOfTheHour = inputMin == ZERO_MINUTE;
        notEdgeTime = !(halfPast || quarterPast || quarterTo || topOfTheHour);

        // Get the right values of time to convert to string based on location of hands on the clock
        // Minute is in second half of hour - TO area
        if (notEdgeTime && inputMin > THIRTY_MINUTES && inputMin <= FIFTYNINE_MINUTES) {
            inputMin = (FIFTYNINE_MINUTES + ONE_MINUTE) - inputMin;
            inputHr += 1;
            pastThirty = true;
        }




        minuteString = get_minute() > ONE_MINUTE ? "minutes " : "minute ";



        // Convert hour and minute to string representations.
        String hour = IntToStringConverter.convert(get_hour());
        String minute = IntToStringConverter.convert(get_minute());

        if (notEdgeTime) {
            // Minute is just in first half of hour - PAST area
            if (get_minute() >= ZERO_MINUTE && get_minute() < THIRTY_MINUTES) {
                translation.append(minute + " " + minuteString + " ");
                translation.append("after" + hour);
            }
            // Minute is heading towards a new hour - TO area
            else {
                minuteDifference = get_minute() - THIRTY_MINUTES;
                minuteString = minuteDifference > ONE_MINUTE ? "minutes " : "minute ";
                translation.append(minute + " " + minuteString + " ");
                translation.append("before " + hour);
            }
        }
        // Top of hour, quarter (past/to), half past
        else {

        }
        return translation.toString();
//        return String.format("%s,%s", hour, minute);

    }

    /* All input validations go here
     * 1. Validate the time range of input
      * 2. Ensure the input format of input (AM or PM) */
    protected void validateInput() throws AssertionError {
        /* Ensure number in normal time range */
        if ((this._hour < 0) || (this._hour > 23)) throw new AssertionError("[TIME RANGE ERROR] - Allowed Hour range is 0-23");
        if ((this._minute < 0) || (this._minute > 59)) throw new AssertionError("[TIME RANGE ERROR] - Allowed Minute range is 0-59");

        /* If in the PM, normalize hour */
        if (this._isTimePM) set_hour(this._hour % 12);
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
