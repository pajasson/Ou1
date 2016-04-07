/**
 * Created by Niklas Königsson dv15nkn on 2016-04-06.
 */
import java.util.Scanner;

/**
 * Class with an executable program to test the Alarm class
 */
public class AlarmProgram {


    /**
     * The main testprogram.
     * The different useroptions accepts only integer-values
     */
    public static void main(String[] args){

        //creates an alarm set to 00:00 with alarm turned off and initialize
        //the scanner
        Alarm alarmClock = new Alarm(0, 0);
        Scanner read = new Scanner(System.in);

        //Variables to hold user choices
        int option = 1;
        int setHour = 0;
        int setMinute = 0;

        //while the user hasn't chosen to exit
        while(option != 0){

            //display the menu and read in next input
            menu(alarmClock);
            System.out.printf("\nChoose option : ");
            option = read.nextInt();

            switch(option){

                //Lets the user set the alarm
                case 1 :

                    System.out.printf("\nSet hours: ");
                    setHour = read.nextInt();

                    System.out.printf("\nSet minutes: ");
                    setMinute = read.nextInt();

                    alarmClock.setAlarm(setHour, setMinute);
                    break;

                //Lets the user turn alarm on
                case 2:

                    alarmClock.alarmOn();
                    break;

                //Lets the user turn alarm off
                case 3:

                    alarmClock.alarmOff();
                    break;

                //Lets the user set the time
                case 4:

                    System.out.printf("\nSet hours: ");
                    setHour = read.nextInt();

                    System.out.printf("\nSet minutes: ");
                    setMinute = read.nextInt();

                    alarmClock.setTime(setHour, setMinute);
                    break;

                //Lets the user specify a number of minutes for the clock
                //to fastforward
                case 5:
                    System.out.printf("\nType in number of minutes to run: ");
                    setMinute = read.nextInt();

                    System.out.printf("\n%s ", alarmClock.getTime());

                    for(int i = 0; i < setMinute; i++){
                        alarmClock.timeTick();
                        System.out.printf("\n%s ", alarmClock.getTime());
                    }
                    break;

                //Lets the user specify a number of hours for the clock
                //to fastforward
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

                //exits the program
                case 0:

                    break;

                default:

                    System.out.printf("\nInvalid choice!\n");
            }
        }
    }

    /**
     * private class used by main to display the menu
     * @param alarm Is the alarmobject to read the values from
     */
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
