package aron.hacker_rank.continuous_median;

import java.util.HashMap;
import java.util.Map;

public class Sorts {
    private static class IntegerWithOccurrence {
        int number;
        int times;

        public IntegerWithOccurrence(final int number) {
            this.number = number;
            this.times = 1;
        }

        @Override
        public boolean equals(final Object obj) {
            if ( !(obj instanceof IntegerWithOccurrence other) ) return false;
            if (this == obj) return true;  // self check

            return number == other.number;
        }
    }

    public static void printArray(final int[] arr) {
        for (int i : arr) System.out.printf("%d ", i);
        System.out.println();
    }

    public static void bubbleSort(final int[] arr, final boolean verbose) {
        int tmp;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( verbose ) System.out.printf("i=%d\n", i);

            for ( int j = i + 1; j < arr.length; j++ ) {
                if ( verbose ) System.out.printf("j=%d ", j);
                if ( arr[j] < arr[i] ) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }

            if ( verbose ) System.out.println();
        }
    }

    public static double findMedian(final int[] arr) {
        if ( arr.length == 1 ) return arr[0];

        if ( arr.length % 2 == 0 ) {
            int j = arr.length / 2;
            int i = j - 1;

            return (arr[i] + arr[j]) / 2.0;

        } else {
            return arr[arr.length / 2];
        }
    }

    public static int findMax(final int[] arr) {
        int n = arr[0];
        for ( int i : arr ) if ( i > n ) n = i;

        return n;
    }

    public static int findMin(final int[] arr) {
        int n = arr[0];
        for ( int i : arr ) if ( i < n ) n = i;

        return n;
    }

    public static double average(final int[] arr) {
        int sum = 0;
        for ( int i : arr ) sum += i;

        return (double) sum / arr.length;
    }

    public static int mostCommon(final int[] arr) {
        final Map<Integer,Integer> collector = new HashMap<>();

        for ( int n : arr ) {
            if ( ! collector.containsKey(n) ) collector.put(n, 1);
            else collector.put(n, collector.get(n) + 1);
        }

        int most_common_number = arr[0];
        int most_occurrences = 1;

        for ( Map.Entry<Integer, Integer> e : collector.entrySet() ) {
            if ( e.getValue() > most_occurrences ) {
                most_occurrences = e.getValue();
                most_common_number = e.getKey();
            }
        }

        return most_common_number;
    }
}
