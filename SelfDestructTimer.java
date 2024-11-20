import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

public class SelfDestructTimer {

    public static void main(String[] args) {
        // Start with a 30-second interval (30,000 milliseconds)
        long interval = 30000;
        // Minimum interval (in milliseconds) before stopping
        final long MIN_INTERVAL = 200; // 0.2 seconds
        // Decrement amount (reduce interval after each beep)
        final long DECREMENT = 2000; // 2 seconds per step
        
        // Get the toolkit for making the beep
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        System.out.println("Self Destruct Timer Initialized!");

        try {
            while (interval >= MIN_INTERVAL) {
                // Beep and print the current interval
                toolkit.beep();
                System.out.println("Beep! Interval: " + interval + " ms");

                // Sleep for the current interval
                TimeUnit.MILLISECONDS.sleep(interval);

                // Gradually reduce the interval
                interval -= DECREMENT;
            }

            // Final countdown (rapid beeps at MIN_INTERVAL)
            System.out.println("Final Countdown!");
            for (int i = 0; i < 10; i++) {
                toolkit.beep();
                System.out.println("Beep!");
                TimeUnit.MILLISECONDS.sleep(MIN_INTERVAL);
            }

            // Simulate the "destruction"
            System.out.println("Self Destruct Sequence Complete!");
            for (int i = 0; i < 5; i++) {
                toolkit.beep();
                TimeUnit.MILLISECONDS.sleep(500);
            }

        } catch (InterruptedException e) {
            System.err.println("Timer interrupted: " + e.getMessage());
        }
    }
}
