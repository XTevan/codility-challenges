package com.hilst.studies.codility.lessons.prefixSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassingCars {
    private static final int MAX_PAIRS = 1000000000;

    public static void main(String[] args) {
        PassingCars runner = new PassingCars();
        runner.test(new int[]{0,1,0,1,1},5);
        runner.test(new int[]{0,1,1,0,1,1,1,0,1,1,1,1},20);
        runner.test(new int[]{1,1,0,1,1},2);
        runner.test(new int[]{1,0,1,1,0},2);
        runner.test(new int[]{0},0);
        runner.test(new int[]{1},0);
        runner.test(new int[]{1,1},0);
        runner.test(new int[]{0,0},0);
        runner.test(new int[]{0,0,1},2);
        runner.test(new int[]{1,1,0},0);

    }

    public void test(int[] A, int expectedResult) {
        int result = solution(A);
        System.out.println(Arrays.toString(A));
        System.out.println(result);
        System.out.println(expectedResult == result);
    }
    public int solution(int[] A) {
        int result = 0;
        List<Integer> indexOfZeros = new ArrayList<>();

        for (int index = 0; index < A.length; index++) {
            if(A[index] == 0)
                indexOfZeros.add(index);
        }
        if(indexOfZeros.size() > 0) {
            int deltaLength = A.length - indexOfZeros.size();
            for (int i = 0; i < indexOfZeros.size() && result <= MAX_PAIRS; i++) {
                result += deltaLength - indexOfZeros.get(i) + i;
            }

        }
        return result <= MAX_PAIRS ? result : -1;
    }
}
