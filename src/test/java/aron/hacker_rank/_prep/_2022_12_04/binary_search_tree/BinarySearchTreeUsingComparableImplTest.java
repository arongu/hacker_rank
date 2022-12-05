package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeUsingComparableImplTest {
    private static final BinarySearchTreeUsingComparable<String> treeString;
    private static final BinarySearchTreeUsingComparable<Integer> treeInteger;

    static {
        treeString  = new BinarySearchTreeUsingComparableImpl<String>();
        treeInteger = new BinarySearchTreeUsingComparableImpl<Integer>();
    }

    @Test
    void stringTreeTest(){
        treeString.add("aron");
        treeString.add("alma");
        treeString.add("barna");
        treeString.add("Zorro");
        treeString.add("ABC");
        treeString.add("Bea");
        treeString.printInOrder();
    }

    @Test
    void integerTreeTest(){
        treeInteger.add(0);
        treeInteger.add(10);
        treeInteger.add(52);
        treeInteger.add(2);
        treeInteger.add(14);
        treeInteger.printInOrder();
    }
}
