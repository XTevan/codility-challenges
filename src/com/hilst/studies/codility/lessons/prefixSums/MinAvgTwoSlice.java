package com.hilst.studies.codility.lessons.prefixSums;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class MinAvgTwoSlice {
    private static final int MAX_SIZE = 100_000;
    private static final int MAX_NUMBER = 10_000;
    private static final int MIN_NUMBER = -MAX_NUMBER;

    public static void main(String[] args) {
        MinAvgTwoSlice runner = new MinAvgTwoSlice();
//        runner.test(new int[]{1,2},0);
//        runner.test(new int[]{2,2},0);

//        runner.test(new int[]{1, 2, 3, 4}, 0);
//        runner.test(new int[]{4, 3, 2, 1}, 2);
//        runner.test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);
        runner.test(new int[]{4, 2, 2, 5, 1, 5, 8}, 1);
//
//        runner.test(new int[]{-9956, 3034, -4424, 6561, 9007, -7514, -9847, -4299, -5125, 3325, 7004, -7824, 1360, -3583,
//                -7231, -143, 4950, -4086, 6039, 2273, -2298, -6791, -7366, 163, 3239, 6901, 4278, 3846, 2620, -6634, 8555,
//                -2001, 1557, -4417, -2408, -6203, -6380, -3455, -4845, -291, 6246, 8472, -6206, 6488}, 33);


        //runner.testWithRandomValues();
//        runner.test(new int[]{1991, 7374, -2033, 8696, 3862, 2832}, 2);
    }

    public int solution(int[] A) {

        int lastIndex = A.length - 1;
        long[] forwardSumValues = new long[A.length];
        long[] backwardSumValues = new long[A.length];
        long forwardSum = 0l;
        long backwardSum = 0l;
        Instant init = Instant.now();
        long count = 0;

        for (int index = 0; index < A.length; index++) {
            forwardSum += A[index];
            backwardSum += A[lastIndex - index];
            forwardSumValues[index] = forwardSum;
            backwardSumValues[lastIndex - index] = backwardSum;
        }


        double minAvg = backwardSum / (double)A.length;
        int minIndex = 0;
        double currentAvg;

        for (int start = 0; start < lastIndex; start++) {
            currentAvg = backwardSumValues[start] / (double)(backwardSumValues.length - start) ;

            if (currentAvg < minAvg) {
                minAvg = currentAvg;
                minIndex = start;
            }
            for (int end = start + 1; end < lastIndex; end++) {

                currentAvg = sliceAverage(forwardSumValues, backwardSumValues, start, end);
                if (currentAvg < minAvg) {
                    minAvg = currentAvg;
                    minIndex = start;
                }
            }
        }

        Instant finish = Instant.now();

        System.out.println("Elapsed: " + Duration.between(init,finish));
        System.out.println("Size: " +  A.length + "\tCount: " + count);
        System.out.printf("Min: [%d] -> %f\n", minIndex, minAvg);
        return minIndex;
    }

    private double sliceAverage(long[] forwardSumValues, long[] backwardSumValues, int start, int end) {

        long previousSum = start - 1 < 0 ? 0 : forwardSumValues[start - 1];
        long nextSum = end + 1 > backwardSumValues.length - 1 ? 0 : backwardSumValues[end + 1];
        Double average = (backwardSumValues[0] - (previousSum + nextSum)) / new Double((end - start) + 1);

        return average;
    }

    private int[] randomSequence() {
        Random generator = new Random();
        int size = generator.nextInt(MAX_SIZE);
        int[] A = generator.ints(size, MIN_NUMBER, MAX_NUMBER + 1).toArray();
        System.out.println("Array size: " + A.length);
        return A;
    }


    private void testWithRandomValues() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Iteration # " + i);
            int[] randomSequence = randomSequence();
            int result = solution(randomSequence);
            int expectedResult = calculateIndex(randomSequence);
            if (result != expectedResult) {
                test(randomSequence, expectedResult);
                break;
            }
        }
    }


    public void test(int[] A, int expectedResult) {
        int result = solution(A);
        System.out.println(calculateIndex(A));
        System.out.println(Arrays.toString(A));
        System.out.println(expectedResult == result);

    }

    public int calculateIndex(int[] A) {

        int lastIndex = A.length - 1;
        long[] forwardSumValues = new long[A.length];
        long[] backwardSumValues = new long[A.length];
        long forwardSum = 0l;
        long backwardSum = 0l;
        Instant init = Instant.now();

        for (int index = 0; index < A.length; index++) {
            forwardSum += A[index];
            backwardSum += A[lastIndex - index];
            forwardSumValues[index] = forwardSum;
            backwardSumValues[lastIndex - index] = backwardSum;
        }


        double minAvg = backwardSum / (double)A.length;
        int minIndex = 0;
        double currentAvg;

        for (int start = 0; start < lastIndex; start++) {
            currentAvg = backwardSumValues[start] / (double)(backwardSumValues.length - start) ;
            if (currentAvg < minAvg) {
                minAvg = currentAvg;
                minIndex = start;
            }
            for (int end = start + 1; end < lastIndex; end++) {
                currentAvg = sliceAverage(forwardSumValues, backwardSumValues, start, end);
                if (currentAvg < minAvg) {
                    minAvg = currentAvg;
                    minIndex = start;
                }
            }
        }

        Instant finish = Instant.now();

        System.out.println("Elapsed: " + Duration.between(init,finish));

        System.out.printf("Min: [%d] -> %f\n", minIndex, minAvg);
        return minIndex;
    }
}
