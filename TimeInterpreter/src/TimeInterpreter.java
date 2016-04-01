public class TimeInterpreter {
    private int _hour, _minute;
    private boolean _isTimePM;


    /* Overloaded constructors */
    public TimeInterpreter(int hour, int minute) {
        this._hour = hour;
        this._minute = minute;
    }
    public TimeInterpreter(double hour, double minute) {
        // Round to closest hour
        this._hour = (int) (hour + 0.5);
        this._minute = (int) (minute);
    }
    public TimeInterpreter(String hour, String minute) {
        try {
            this._hour = Integer.parseInt(hour);
            this._minute = Integer.parseInt(minute);
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

        return "";
    }

    /* All input validations go here
     * 1. Validate the time range of input
      * 2. Ensure the input format of input (AM or PM) */
    protected void validateInput() throws AssertionError {
        /* Ensure number in normal time range */
        if ((this._hour < 0) || (this._hour > 24)) throw new AssertionError("[TIME RANGE ERROR] - Allowed Hour range is 0-24");
        if ((this._minute < 0) || (this._minute > 59)) throw new AssertionError("[TIME RANGE ERROR] - Allowed Minute range is 0-59");

        /* Is time in the AM or PM */
        if (this._hour > 12) this._isTimePM = true;
    }

    /* Getters and Setters */
    public int get_hour() {
        return this._hour;
    }

    public void set_hour(int hour) {
        this._hour = hour;
    }

    public int get_minute() {
        return this._minute;
    }

    public void set_minute(int minute) {
        this._minute = minute;
    }
}
