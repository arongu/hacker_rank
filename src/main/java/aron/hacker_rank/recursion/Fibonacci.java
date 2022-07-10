package aron.hacker_rank.recursion;

public class Fibonacci {
    private static int calls = 0;

    public static int fib(final int n) {
        calls++;
        if (n <= 1) {
            return n;

        } else {
            return fib(n - 1) + fib(n - 2);

        }
    }

    public static void main(final String[] args) {
        System.out.println(fib(2));
        System.out.println(calls);
    }

}
