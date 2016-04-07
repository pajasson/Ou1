import static java.lang.String.format;

/**
 * Created by Niklas Königsson dv15nkn on 2016-04-04.
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
        if(hour >= 0 && hour < 24){
            hours.setValue(hour);
        }
        if(minute >= 0 && minute < 60){
            minutes.setValue(minute);
        }
    }

    public String getTime(){

        updateDisplay();
        return displayString;
    }

    protected void updateDisplay(){

        displayString = String.format("%s:%s", hours.getDisplayValue(),
                                      minutes.getDisplayValue());

    }
}
