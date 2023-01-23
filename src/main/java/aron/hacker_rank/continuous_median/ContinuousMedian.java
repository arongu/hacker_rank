package aron.hacker_rank.continuous_median;
/*
[ 1, 2, 4, 6, 22, 200, 201 ] odd
           *
[ 12, 17, 18, 22, 23, 200, 201, 204 ] even
               *   *  => 22 + 23 => 45 / 2 => 22.5

    mean = average
    median = middle in sorted order (half the number is below, half the number is above)
    mode = most common number
    solution 1) keep a sorted array and keep shifting the values as numbers come in O(n^2)

    e.g.: 3 2 1
    3,
    3 2,
    2 3
    2 3 1
    1 3 2
    1 2 3

    2 buckets one for the smaller numbers one for the big ones
    - when number comes in -> determine which bucket it goes

    MAX heap for the SMALLER part of the numbers
    MIN heap for the BIGGER  part of the numbers
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {
    public static void addNumber(final int number,
                                 final PriorityQueue<Integer> lowers,
                                 final PriorityQueue<Integer> highers) {

        if ( lowers.size() == 0 || number < lowers.peek() ) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void reBalance(final PriorityQueue<Integer> lowers,
                                 final PriorityQueue<Integer> highers) {

        final PriorityQueue<Integer> biggerHeap  = lowers.size() > highers.size() ? lowers : highers;
        final PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;

        if ( biggerHeap.size() - smallerHeap.size() >= 2 ) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(final PriorityQueue<Integer> lowers,
                                   final PriorityQueue<Integer> highers) {

        final PriorityQueue<Integer> biggerHeap  = lowers.size() > highers.size() ? lowers : highers;
        final PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;

        if ( biggerHeap.size() == smallerHeap.size() ) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }


    public static double[] getMedians(int[] array) {
        final Comparator<Integer> inverseComparator = (left, right) -> -1 * left.compareTo(right);
        final PriorityQueue<Integer> lowers  = new PriorityQueue<>(inverseComparator);
        final PriorityQueue<Integer> highers = new PriorityQueue<>();

        final double[] medians = new double[array.length];

        for ( int i = 0; i < array.length; i++ ) {
            int number = array[i];
            addNumber(number, lowers, highers);
            reBalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }
}
