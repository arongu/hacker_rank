package aron.hacker_rank.continuous_median;
/*
[ 1, 2, 4, 6, 22, 200, 201 ] odd
           *
[ 12, 17, 18, 22, 23, 200, 201, 204 ] even
               *   *  => 22 + 23 => 45 / 2 => 22.5

    mean = average
    median = middle in sorted order
    mode = most common number
    solution 1) keep a sorted array and keep shifting the values as numbers come in O(n^2)

    e.g.: 3 2 1
    3,
    3 2,
    2 3
    2 3 1
    1 3 2
    1 2 3

*/

public class ContinuousMedian {
}
