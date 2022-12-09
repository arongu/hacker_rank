package aron.hacker_rank.continuous_median;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortsTest {
    @Test
    public void sortTest(){
        int[] arr1 = { 1 };
        int[] arr2 = { 4, 12, 8, 5, 1, 100, 14 };
        int[] arr3 = { 16, 4, 13, 12 };

        Sorts.bubbleSort(arr1, false);
        assertEquals(1, Sorts.findMin(arr1));
        assertEquals(1, Sorts.findMax(arr1));
        assertEquals(1, Sorts.findMedian(arr1));

        Sorts.bubbleSort(arr2, false);
        assertEquals(1, Sorts.findMin(arr2));
        assertEquals(100, Sorts.findMax(arr2));
        assertEquals(8, Sorts.findMedian(arr2));

        Sorts.bubbleSort(arr3, false);
        assertEquals(12.5, Sorts.findMedian(arr3));

        Sorts.printArray(arr1);
        Sorts.printArray(arr2);
        Sorts.printArray(arr3);
    }

    @Test
    public void occurrence(){
        int[] arr1 = { 0, 1 };
        int[] arr2 = { 0, 0, 1, 2, 2, 2, 4, 5, 0 };
        int[] arr3 = { 1, 2, 44, 44, 12, 2, 3, 3 , 41};

        assertEquals(0, Sorts.mostCommon(arr1));
        assertEquals(0, Sorts.mostCommon(arr2));
        assertEquals(2, Sorts.mostCommon(arr3));

        assertEquals(0.5, Sorts.average(arr1));
        assertEquals(1.7777777777777777, Sorts.average(arr2));
        assertEquals(16.88888888888889, Sorts.average(arr3));
    }
}
