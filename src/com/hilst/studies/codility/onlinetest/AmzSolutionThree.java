package com.hilst.studies.codility.onlinetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmzSolutionThree {
    public static void main(String[] args) {
        AmzSolutionThree runner = new AmzSolutionThree();


        runner.test(new int[]{9,4,2,10,7,8,8,1,9},5);

    }

    public void test(int[] A, int expectedResult) {
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("Expected value:" + expectedResult);

        int result = solution(A);
        boolean equalValues = result == expectedResult;
        System.out.println(equalValues);
        if(!equalValues)
            System.out.println("Result:" + result);
        System.out.println();
    }

    public int solution(int[] A) {
        int result = 0;

        List<Integer> pointsOfTurbulence = new ArrayList<>();
        for (int index = 1; index < A.length -1; index++) {
            if(A[index] != A[index + 1])
                pointsOfTurbulence.add(index);
        }

        if (pointsOfTurbulence.size() > 1) {
            for (int one = 0; one < pointsOfTurbulence.size() -1; one++) {
                result = Math.max(result, pointsOfTurbulence.get(one + 1) - pointsOfTurbulence.get(one) -1);
            }
        }
        else
            return 0;

        return result;
    }
}
