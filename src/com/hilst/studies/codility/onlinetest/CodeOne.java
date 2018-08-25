package com.hilst.studies.codility.onlinetest;

import java.util.Arrays;

public class CodeOne {
    public static void main(String[] args) {
        CodeOne runner = new CodeOne();
        runner.test(new int[]{1,2,4,3},new int[]{1,3,2,3}, 2);
        runner.test(new int[]{3,2,1,6,5},new int[]{4,2,1,3,3}, 3);
        runner.test(new int[]{1,2},new int[]{1,2}, 3);
        runner.test(new int[]{4,3,3,5,1},new int[]{8,2,5,3,1}, 3);

    }
    public void test(int[] A, int[] B, int expectedResult) {
        System.out.println("B: " + Arrays.toString(B));
        System.out.println("A: " + Arrays.toString(A));
        System.out.println(expectedResult);

        System.out.println(solution(A,B) == expectedResult);
    }

    public int solution(int[] A, int[] B) {
        int minimum = A.length + 1;
        for (int index = 0; index < A.length; index++) {
            if(A[index] < B[index] && A[index] < minimum) {
                minimum = A[index];
            }

        }
        return minimum;
    }
}
