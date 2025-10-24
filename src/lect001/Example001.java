package lect001;

import java.util.Scanner;

public class Example001 {
    // private static boolean shouldRun = true;
    private static volatile boolean shouldRun = true;

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Started.");
                while(shouldRun);
                System.out.println("Stopped, lol.");
            }
        });
        t.start();

        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()) {
            shouldRun = false;
            System.out.println("Stop!");
        }
        scanner.close();
    }
}
