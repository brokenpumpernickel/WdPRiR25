package lect002;

public class Helpers {
    public static boolean isPrime(int n) { // Nie robcie tego w domu!
        for(int i = 2; i < n; ++i)
            if(n % i == 0)
                return false;

        return true;
    }

    static void main() {
        System.out.println("Prime: " + isPrime(1973));
    }
}
