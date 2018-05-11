package com.hilst.studies.codility.lessons.arrays;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(new CyclicRotation().solution(A, K)));

        A = new int[]{1, 2, 3, 4};
        K = 4;

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(new CyclicRotation().solution(A, K)));
    }

    private int[] solution(int[] A, int K) {
        int[] result = new int[A.length];

        for (int index = 0; index < A.length; index++) {
            result[(index + K)%A.length] = A[index];
        }
        return result;
    }
}
