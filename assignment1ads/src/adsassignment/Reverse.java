package adsassignment;

import java.util.Scanner;

public class Reverse {
    public static void reverseOrder(int n, Scanner scanner) {
        if (n == 0) return;
        int num = scanner.nextInt();
        reverseOrder(n - 1, scanner);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        reverseOrder(n, scanner);
        scanner.close();
    }
}
