package aron.hacker_rank.continuous_median.exercises;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {
    private static void addNumber(final int number,
                                  final PriorityQueue<Integer> lowers,
                                  final PriorityQueue<Integer> highers) {

        if ( lowers.size() == 0 || number < lowers.peek() ) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    // 4 3 2 1 l4, l3
    private static void reBalance(final PriorityQueue<Integer> lowers,
                                  final PriorityQueue<Integer> highers) {

        final PriorityQueue<Integer> smaller = lowers.size() < highers.size() ? lowers : highers;
        final PriorityQueue<Integer> bigger  = lowers.size() > highers.size() ? lowers : highers;

        if ( bigger.size() - smaller.size() >= 2 ) { // > 1 -> =2
            smaller.add(bigger.poll());
        }
    }

    private static double getMedian(final PriorityQueue<Integer> lowers,
                                    final PriorityQueue<Integer> highers) {

        final PriorityQueue<Integer> biggerHeap  = lowers.size() >  highers.size() ? lowers : highers;
        final PriorityQueue<Integer> smallerHeap = lowers.size() <= highers.size() ? lowers : highers;

        // peek give you null when there are no elements in the heap
        if ( biggerHeap.size() == smallerHeap.size() ) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    public static double[] getMedians(final int[] array) {
        final Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(final Integer left, final Integer right) {
                return -1 * left.compareTo(right);
            }
        };

        final PriorityQueue<Integer> lowerNumbers  = new PriorityQueue<>(comparator);
        final PriorityQueue<Integer> higherNumbers = new PriorityQueue<>();
        final double[] medians = new double[array.length];

        for ( int i = 0; i < array.length; i++ ) {
            int number = array[i];
            addNumber(number, lowerNumbers, higherNumbers);
            reBalance(lowerNumbers, higherNumbers);
            medians[i] = getMedian(lowerNumbers, higherNumbers);
        }

        return medians;
    }
}
