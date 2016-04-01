public class TimeInterpreter {
    private int _hour, _minute;


    /* Overloaded constructors */
    public TimeInterpreter(int hour, int minute) {
        this._hour = hour;
        this._minute = minute;
    }
    public TimeInterpreter(double hour, double minute) {
        // Round to closest integer
        this._hour = (int) (hour + 0.5);
        this._minute = (int) (minute + 0.5);
    }
    public TimeInterpreter(String hour, String minute) {
        this._hour = Integer.parseInt(hour);
        this._minute = Integer.parseInt(minute);
    }

    /* Instance methods */
    protected void validateInput() {
        if (this._hour < 0) throw new AssertionError("Hour is less than 0.");
        if (this._minute < 0) throw new AssertionError("Minute is less than 0");
    }
}
