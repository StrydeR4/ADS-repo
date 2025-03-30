package adsassignment;

public class PrimeChecker {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 10;

        System.out.println(num1 + " -> " + (isPrime(num1) ? "Prime" : "Composite"));
        System.out.println(num2 + " -> " + (isPrime(num2) ? "Prime" : "Composite"));
    }
}

