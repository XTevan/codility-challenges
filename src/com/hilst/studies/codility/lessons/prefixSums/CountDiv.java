package com.hilst.studies.codility.lessons.prefixSums;

public class CountDiv {
    private static final int MAX = 2000000000;

    public static void main(String[] args) {
        CountDiv runner = new CountDiv();
        runner.test(6, 11, 2);
        runner.test(0, 10, 5);
        runner.test(0, 0, 11);
        runner.test(1, 1, 11);
        runner.test(10, 10, 5);
        runner.test(10, 10, 7);
        runner.test(10, 10, 20);
        runner.test(0, MAX, 1);
        runner.test(0, MAX, MAX);
        runner.test(20, 300, 5);
        runner.test(1, 1, 5);
    }

    public void test(int A, int B, int K) {
        System.out.println("A: " + A + " B: " + B + " K: " + K);
        System.out.println(solution(A, B, K));
    }


    public int solution(int A, int B, int K) {
        int result = 0;

        Double first = Math.ceil(new Double(A) / new Double(K));
        int firstMultiple = first.intValue() * K;
        Double last = Math.floor(new Double(B) / new Double(K));
        int lastMultiple = last.intValue() * K;

        int rest = lastMultiple < A && A == 0 ? 2 : 1;
        result = ((lastMultiple - firstMultiple) / K) + rest;

        return result;
    }
}
