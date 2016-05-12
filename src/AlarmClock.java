/**
 * Created by Niklas Königsson dv15nkn on 2016-04-05.
 */

/**
 * Clock subclass that adds fields and methods to simulate an alarm
 */
public class AlarmClock extends Clock{

    private boolean alarmActive;
    private NumberDisplay alarmHour;
    private NumberDisplay alarmMinute;
    private String alarmString;

    /**
     *Constructor for the alarm
     */
    public AlarmClock(int hour, int minute){

        super();

        alarmHour = new NumberDisplay(0, 23);
        alarmMinute = new NumberDisplay(0,59);
        alarmActive = false;
        updateAlarm();
    }

    /**
     * Increment the alarm 1 minute forward
     * AlarmClock activates if the new time is equal to the alarmtime
     */
    @Override
    public void timeTick(){

        super.timeTick();
    }

    /**
     * Sets the alarmtime;
     * @param hour sets the alarm hour to this value
     * @param minute sets the alarm minute to this value
     */
    public void setAlarm(int hour, int minute){

        alarmHour.setValue(hour);
        alarmMinute.setValue(minute);
        updateAlarm();

    }

    /**
     * Makes the alarm inactive
     * Sets alarmActive to false
     */
    public void alarmOff(){

        alarmActive = false;
    }

    /**
     * Makes the alarm active
     * Sets alarmActive to true
     */
    public void alarmOn(){

        alarmActive = true;
    }

    /**
     * Get the current time of the alarm
     * @return The time in Stringformat
     */
    private String getAlarmTime(){

        return alarmString;
    }

    /**
     * Check if the alarm should activate on current time
     * @return boolean value
     */
    public boolean alarmCheck(){

        if(alarmActive && (getTime().equals(getAlarmTime()))){

            return true;
        }
        return false;
    }

    /**
     * Updates the alarmdisplay
     */
    private void updateAlarm(){

        alarmString = String.format("%s:%s", alarmHour.getDisplayValue(),
                                    alarmMinute.getDisplayValue());

    }
}
