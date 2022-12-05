package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

import java.util.Comparator;

public class ComparatorInteger implements Comparator<Integer> {
    @Override
    public int compare(final Integer left, final Integer right) {
        return left - right;
    }
}
