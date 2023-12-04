package Day5;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SophisticatedTimer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the duration of the timer in seconds
        System.out.println("Enter the duration of the timer in seconds:");
        int duration = sc.nextInt();

        // Read the message to be displayed when the timer ends
        System.out.println("Enter the message to be displayed when the timer ends:");
        String message = sc.next();

        // Set the timer to run the task after the specified duration
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // The task to run after the specified duration
                System.out.println(message);
            }
        }, duration * 1000);

        // Print the countdown
        for (int i = duration; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
