package lect002;

public class Helpers {
    public static boolean isPrime(int n) { // Nie robcie tego w domu!
        for(int i = 2; i < n; ++i)
            if(n % i == 0)
                return false;

        return true;
    }

    public static double fibon(double n) {
        if(n < 2)
            return n;

        return fibon(n - 1) + fibon(n - 2);
    }

    static void main() {
        // System.out.println("Prime: " + isPrime(1973));

        for(int i = 0; i < 50; ++i) {
            System.out.println(i + " " + fibon(i));
        }
    }
}
