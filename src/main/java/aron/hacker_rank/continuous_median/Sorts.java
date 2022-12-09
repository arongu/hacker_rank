package aron.hacker_rank.continuous_median;

public class Sorts {
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

    /*
        [ 1, 2 ] = 2 / 1;
            index 1 - 1 => 0;
            index 1

        [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 10 / 2
            index 4
            index 4 + 1

        [ 1 , 2, 3 ] => len / 2 => 1
        [1 , 2 , 3, 4, 5 ] => len / 2 => 2
     */

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
}
