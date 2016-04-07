/**
 * Created by Niklas königsson dv15nkn on 2016-04-05.
 */
public class Alarm extends Clock{

    protected boolean alarmActive;
    protected int alarmHour;
    protected int alarmMinute;

    public Alarm(int hour, int minute){

        super(hour, minute);
        alarmActive = false;
    }

    @Override
    public void timeTick(){

        super.timeTick();

        if(alarmActive && (hours.getValue() == alarmHour)
                && (minutes.getValue() == alarmMinute)){

            System.out.printf("\nAlarm");
        }
    }

    public void setAlarm(int hour, int minute){

        if(hour >= 0 && hour < 24){
            alarmHour = hour;
        }
        if(minute >= 0 && minute < 60){
            alarmMinute = minute;
        }

    }

    public void alarmOff(){

        alarmActive = false;
    }

    public void alarmOn(){

        alarmActive = true;
    }
}
