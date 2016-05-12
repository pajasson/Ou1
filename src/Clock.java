/**
 * Created by Niklas Königsson dv15nkn on 2016-04-04.
 */

/**
 * Class that simulates a clock. Uses the NumberDisplay class
 */
public class Clock {

    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    /**
     * Constructor for the clock
     */
    public Clock(){

        hours = new NumberDisplay(0, 23);
        minutes = new NumberDisplay(0, 59);
        setTime(0,0);
        updateDisplay();
    }

    /**
     * Constructor for the clock
     * @param hour sets the new clocks hour to this value
     * @param minute sets the new clocks minute to this value
     */
    public Clock(int hour, int minute) {

        hours = new NumberDisplay(0, 23);
        minutes = new NumberDisplay(0, 59);

        hours.setValue(hour);
        minutes.setValue(minute);

        updateDisplay();
    }

    /**
     * Increment the clock 1 minute forward
     */
    public void timeTick(){

        minutes.increment();
        if(minutes.didWrapAround()){
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Sets the clocks time;
     * @param hour sets the clocks hour to this value
     * @param minute sets the clocks minute to this value
     */
    public void setTime(int hour, int minute){

        hours.setValue(hour);
        minutes.setValue(minute);

        updateDisplay();
    }

    /**
     * Get the current time of the clock
     * @return The time in Stringformat
     */
    public String getTime(){

        return displayString;
    }

    /**
     * Updates the timedisplay
     */
    private void updateDisplay(){

        displayString = String.format("%s:%s", hours.getDisplayValue(),
                                      minutes.getDisplayValue());

    }
}
