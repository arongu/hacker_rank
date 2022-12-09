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
