package adsassignment;

public class AverageCalculator1 {
    public static double calculateAverage(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return (double) sum / n;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1};
        int n = arr.length;
        System.out.println("average: " + calculateAverage(arr, n));
    }
}

