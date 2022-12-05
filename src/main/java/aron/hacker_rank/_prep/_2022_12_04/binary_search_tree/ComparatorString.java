package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

import java.util.Comparator;

public class ComparatorString implements Comparator<String> {
    @Override
    public int compare(final String left, final String right) {
        return left.compareTo(right);
    }
}
