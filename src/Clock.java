/**
 * Created by Niklas Königsson dv15nkn on 2016-04-04.
 */

/**
 * Class that simulates a clock. Uses the NumberDisplay class
 */
public class Clock {

    protected NumberDisplay hours;
    protected NumberDisplay minutes;
    protected String displayString;

    /**
     * Constructor for the clock
     */
    public Clock(){

        hours = new NumberDisplay(0, 23);
        minutes = new NumberDisplay(0, 59);
    }

    /**
     * Constructor for the clock
     * @param hour sets the new clocks hour to this value
     * @param minute sets the new clocks minute to this value
     * @throws IllegalArgumentException
     */
    public Clock(int hour, int minute) throws IllegalArgumentException {

        if(hour > 23 || hour < 0)
        {
            throw new IllegalArgumentException("Hour out of range");
        }
        if(minute > 59 || minute < 0)
        {
            throw new IllegalArgumentException("Minute out of range");
        }
        hours = new NumberDisplay(0, 23);
        minutes = new NumberDisplay(0, 59);

        hours.setValue(hour);
        minutes.setValue(minute);
    }

    /**
     * Increment the clock 1 minute forward
     */
    public void timeTick(){

        minutes.increment();
        if(minutes.didWrapAround()){
            hours.increment();
        }
    }

    /**
     * Sets the clocks time;
     * @param hour sets the clocks hour to this value
     * @param minute sets the clocks minute to this value
     * @throws IllegalArgumentException
     */
    public void setTime(int hour, int minute){

        if(hour > 23 || hour < 0)
        {
            throw new IllegalArgumentException("Hour out of range");
        }
        if(minute > 59 || minute < 0)
        {
            throw new IllegalArgumentException("Minute out of range");
        }
        hours.setValue(hour);
        minutes.setValue(minute);
    }

    /**
     * Get the current time of the clock
     * @return The time in Stringformat
     */
    public String getTime(){

        updateDisplay();
        return displayString;
    }

    /**
     * Internal method used by getTime
     */
    protected void updateDisplay(){

        displayString = String.format("%s:%s", hours.getDisplayValue(),
                                      minutes.getDisplayValue());

    }
}
