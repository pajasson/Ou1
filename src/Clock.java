import static java.lang.String.format;

/**
 * Created by konig on 2016-04-04.
 */
public class Clock {

    protected NumberDisplay hours;
    protected NumberDisplay minutes;
    protected String displayString;

    public Clock(){

        hours = new NumberDisplay(0, 23);
        minutes = new NumberDisplay(0, 59);
    }

    public Clock(int hour, int minute){

        hours = new NumberDisplay(0, 23);
        minutes = new NumberDisplay(0, 59);

        hours.setValue(hour);
        minutes.setValue(minute);
    }

    public void timeTick(){

        minutes.increment();
        if(minutes.didWrapAround()){
            hours.increment();
        }
    }

    public void setTime(int hour, int minute){

        hours.setValue(hour);
        minutes.setValue(minute);
    }

    public String getTime(){

        updateDisplay();
        return displayString;
    }

    private void updateDisplay(){

        displayString = String.format("%s:%s", hours.getDisplayValue(), minutes.getDisplayValue());
    }
}
