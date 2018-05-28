package com.hilst.studies.codility.lessons.countingElements;

import java.util.Arrays;
import java.util.Random;

public class MaxCounters {
    private static final int SIZE = 10000;
    public static void main(String[] args) {
        MaxCounters runner = new MaxCounters();
        /*
        int N = 5;
        int[] first = {3,4,4,6,1,4,4};

        runner.test(N,first);

        runner.test(6,new int[]{1,5,4,4,7,6,5,4,7,2,2,1});

        runner.test(10,new int[]{10,11,1,2,3,4,5,6,7,8,9});

        runner.test(10,new int[]{10,9,11,1,2,3,4,5,6,7,8,9});

        runner.test(19,new int[]{8, 15, 13, 10, 12, 5, 18, 8, 17, 1, 15, 14, 4, 10, 1, 20, 13, 6, 11, 20});

        runner.test(8,new int[]{2, 8, 5, 9, 6, 9, 3, 1, 2, 1, 9, 1, 7, 9, 5, 2, 4, 4, 6, 6});

        runner.test(18,new int[]{15, 16, 1, 5, 16, 14, 7, 11, 1, 5, 7, 7, 13, 19, 1, 12, 16, 18, 13, 3});
        */
        runner.random();
    }

    public void random() {
        Random generator = new Random();
        int N = generator.nextInt(SIZE);
        boolean equalResult = true;
        for (int i = 0; i < SIZE && equalResult ; i++) {
            System.out.println("Iteration: "+ i);
            while (N == 0)
                N = generator.nextInt(SIZE);

            int[] A = generator.ints(SIZE,1,N +2).toArray();
            equalResult = test(N,A);
        }


    }

    public boolean test(int N, int[] A) {
        int[] first = solution(N,A);
        int[] second = solutionA(N,A);
        int[] third = new int[N];
        for (int i = 0; i < N; i++) {
            third[i] = i + 1;
        }
        boolean equalResult = Arrays.equals(first, second);
        System.out.println("input: N = " + N + " A = " + Arrays.toString(A));
        System.out.println("Sample: " + Arrays.toString(third));
        System.out.println("Result: " + Arrays.toString(first));
        System.out.println("Result: " + Arrays.toString(second));
        System.out.println("Equals: " + equalResult);
        return equalResult;

    }

    public int[] solution(int N, int[] A) {//optimal!
        int[] result = new int[N];
        int maxCounter = 0, lastMaxCounter = 0, lastMaxCounterIndex = 0;
        for (int index = 0; index < A.length; index++) {
            if(A[index] > N) {
                lastMaxCounter = maxCounter;
                lastMaxCounterIndex = index;
            }else{
                if(result[A[index]-1] < lastMaxCounter)
                    result[A[index]-1] = lastMaxCounter;
                result[A[index]-1]++;
                maxCounter = Math.max(maxCounter, result[A[index]-1] );
            }
        }

        if(lastMaxCounterIndex > 0) {
            Arrays.fill(result, lastMaxCounter);
            for (int index = lastMaxCounterIndex + 1; index < A.length; index++) {
                result[A[index] - 1]++;
            }
        }
        return result;
    }

    public int[] solutionA(int N, int[]A) {
        int[] result = new int[N];
        int maxCounter = 0;
        for (int index = 0; index < A.length; index++) {
            if (A[index] > N) {
                Arrays.fill(result,maxCounter);
            }else {
                result[A[index]-1]++;
                maxCounter = Math.max(maxCounter, result[A[index]-1] );
            }
        }
        return result;
    }
}
