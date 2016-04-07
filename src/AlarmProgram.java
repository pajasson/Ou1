/**
 * Created by konig on 2016-04-06.
 */
import java.util.Scanner;

public class AlarmProgram {


    public static void main(String[] args){

        Alarm alarmClock = new Alarm(0, 0);
        Scanner read = new Scanner(System.in);
        int option = 1;
        int setHour = 0;
        int setMinute = 0;

        while(option != 0){

            menu(alarmClock);
            System.out.printf("\nChoose option : ");
            option = read.nextInt();

            switch(option){

                case 1 :

                    System.out.printf("\nSet hours: ");
                    setHour = read.nextInt();

                    System.out.printf("\nSet minutes: ");
                    setMinute = read.nextInt();

                    alarmClock.setAlarm(setHour, setMinute);
                    break;

                case 2:

                    alarmClock.alarmOn();
                    break;

                case 3:

                    alarmClock.alarmOff();
                    break;

                case 4:

                    System.out.printf("\nSet hours: ");
                    setHour = read.nextInt();

                    System.out.printf("\nSet minutes: ");
                    setMinute = read.nextInt();

                    alarmClock.setTime(setHour, setMinute);
                    break;

                case 5:
                    System.out.printf("\nType in number of minutes to run: ");
                    setMinute = read.nextInt();

                    System.out.printf("\n%s ", alarmClock.getTime());

                    for(int i = 0; i < setMinute; i++){
                        alarmClock.timeTick();
                        System.out.printf("\n%s ", alarmClock.getTime());
                    }
                    break;

                case 6:

                    System.out.printf("\nType in number of hours to run: ");
                    setHour = read.nextInt();

                    System.out.printf("\n%s ", alarmClock.getTime());

                    for(int i = 0; i < setHour; i++){
                        for(int j = 0; j < 60; j++){
                            alarmClock.timeTick();
                            System.out.printf("\n%s ", alarmClock.getTime());
                        }
                    }
                    break;

                case 0:

                    break;

                default:

                    System.out.printf("\nInvalid choice!\n");
            }
        }
    }

    private static void menu(Alarm alarm){

        String status;
        if(alarm.alarmActive){
            status = "ON";
        }else{
            status = "OFF";
        }

        System.out.printf("\nTime is %s ", alarm.getTime());
        System.out.printf("and the alarmtime is %02d:%02d",
                          alarm.alarmHour, alarm.alarmMinute);
        System.out.printf("\nThe alarm is currently %s", status);

        System.out.printf("\nMENU:");
        System.out.printf("\n1 : Set the alarm");
        System.out.printf("\n2 : Turn on the alarm");
        System.out.printf("\n3 : Turn off the alarm");
        System.out.printf("\n4 : Set the time");
        System.out.printf("\n5 : Run the clock x minutes");
        System.out.printf("\n6 : Run the clock x hours");
        System.out.printf("\n0 : QUIT");
    }
}
