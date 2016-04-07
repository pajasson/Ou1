/**
 * Created by Niklas Königsson dv15nkn on 2016-04-05.
 */

/**
 * Clock subclass that adds fields and methods to simulate an alarm
 */
public class Alarm extends Clock{

    protected boolean alarmActive;
    protected int alarmHour;
    protected int alarmMinute;

    /**
     *Constructor for the alarm
     */
    public Alarm(int hour, int minute){

        super(hour, minute);
        alarmActive = false;
    }

    /**
     * Increment the alarm 1 minute forward
     * Alarm activates if the new time is equal to the alarmtime
     */
    @Override
    public void timeTick(){

        super.timeTick();

        if(alarmActive && (hours.getValue() == alarmHour)
                && (minutes.getValue() == alarmMinute)){

            System.out.printf("\nAlarm");
        }
    }

    /**
     * Sets the alarmtime;
     * @param hour sets the alarm hour to this value
     * @param minute sets the alarm minute to this value
     * @throws IllegalArgumentException
     */
    public void setAlarm(int hour, int minute){

        if(hour > 23 || hour < 0)
        {
            throw new IllegalArgumentException("Hour out of range");
        }
        if(minute > 59 || minute < 0)
        {
            throw new IllegalArgumentException("Minute out of range");
        }
        alarmHour = hour;
        alarmMinute = minute;
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
}
