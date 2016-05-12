/**
 * Created by Niklas Königsson dv15nkn on 2016-05-12.
 */
public class AlarmTestProgram {

    public static void main(String[] args){

        System.out.println("Creating new alarmclock");
        AlarmClock alarmClock = new AlarmClock(0, 0);
        System.out.println("Alarmclock created\n");

        //Check if new alarm has alarm turned off
        System.out.println("Setting alarmclock to 00:00. Alarm should not " +
                           "activate with status OFF as default ");
        alarmClock.setAlarm(0, 0);
        if(alarmClock.alarmCheck()){

            System.out.println("Alarm");
        }
        System.out.printf("Time: %s ", alarmClock.getTime());

        //testing settime method
        System.out.println("\n\nSetting time to 01:00");
        alarmClock.setTime(1, 0);
        System.out.printf("New time: %s ", alarmClock.getTime());

        //testing alarmOn and alarmCheck methods
        System.out.println("\n\nSetting alarm to 01:01 and activating it." +
                           " Running the time 1 min forward");
        alarmClock.setAlarm(1, 1);
        alarmClock.alarmOn();
        alarmClock.timeTick();
        if(alarmClock.alarmCheck()){

            System.out.println("Alarm");
        }
        System.out.printf("New time: %s ", alarmClock.getTime());

        //testing numberdisplays wraparound in 2 steps
        System.out.println("\n\nSetting alarm to 02:00 and running the clock" +
                           " to the same to check minute wraparound");
        alarmClock.setAlarm(2, 0);
        for(int i = 0; i < 59; i++){
            alarmClock.timeTick();
            if(alarmClock.alarmCheck()){

                System.out.println("Alarm");
            }
        }
        System.out.printf("New time: %s ", alarmClock.getTime());
        //step 2
        System.out.println("\n\nSetting alarm to 00:00 and running the clock" +
                " to the same to check hour wraparound");
        alarmClock.setAlarm(0, 0);
        for(int i = 0; i < 22; i++){
            for(int j = 0; j < 60; j++){
                alarmClock.timeTick();
                if(alarmClock.alarmCheck()){

                    System.out.println("Alarm");
                }
            }
        }
        System.out.printf("New time: %s ", alarmClock.getTime());

        //testing alarmOff method and running the clock 24hours
        System.out.println("\n\nTurning alarm OFF and running the clock 24h" +
                           ". Should produce no alarm");
        alarmClock.alarmOff();
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 60; j++){
                alarmClock.timeTick();
                if(alarmClock.alarmCheck()){

                    System.out.println("Alarm");
                }
            }
        }
        System.out.printf("New time: %s ", alarmClock.getTime());

        //testing illegalargument exeptions step 1
        System.out.println("\n\nSetting time with minute out of range. Should" +
                           " produce illegal argument exeption");
        try
        {
            alarmClock.setTime(00, 99);
            System.out.println(alarmClock.getTime());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Minute out of clock range");
        }
        //step 2
        System.out.println("\nSetting time with hour out of range. Should" +
                " produce illegal argument exeption");
        try
        {
            alarmClock.setTime(99, 00);
            System.out.println(alarmClock.getTime());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Hour out of clock range");
        }

        System.out.println("\nTests done");



    }
}
