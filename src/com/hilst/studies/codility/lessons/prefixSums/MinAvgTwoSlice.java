package com.hilst.studies.codility.lessons.prefixSums;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MinAvgTwoSlice {
    private static final int MAX_SIZE = 100_000;
    private static final int MAX_NUMBER = 10_000;
    private static final int MIN_NUMBER = -MAX_NUMBER;

    public static void main(String[] args) {
        MinAvgTwoSlice runner = new MinAvgTwoSlice();
        runner.test(new int[]{1,2},0);
        runner.test(new int[]{2,2},0);

        runner.test(new int[]{1,2,3,4},0);
        runner.test(new int[]{4,3,2,1},2);
        runner.test(new int[]{1,2,3,4,5,6,7,8,9,10},0);
        runner.test(new int[]{4,2,2,5,1,5,8},1);

        runner.test(new int[]{-9956, 3034, -4424, 6561, 9007, -7514, -9847, -4299, -5125, 3325, 7004, -7824, 1360, -3583,
         -7231, -143, 4950, -4086, 6039, 2273, -2298, -6791, -7366, 163, 3239, 6901, 4278, 3846, 2620, -6634, 8555, -2001,
          1557, -4417, -2408, -6203, -6380, -3455, -4845, -291, 6246, 8472, -6206, 6488},33);


//        runner.testWithRandomValues();
        runner.test(new int[]{1991, 7374, -2033, 8696, 3862, 2832},2);
    }

    public int solution(int[] A) {
        int minIndex = Integer.MAX_VALUE;
        int lastIndex = A.length - 1;
        double minAvg = Double.MAX_VALUE;
        double currentAvg = minAvg;

        for (int start = 0; start < lastIndex; start++) {
            for (int end = start + 1; end < A.length; end++) {
                currentAvg = sliceAverage(A,start,end);
                if(currentAvg < minAvg) {
                    minAvg = currentAvg;
                    minIndex = start;
                }
            }


        }
        System.out.printf("Min: [%d] -> %f\n",minIndex,minAvg);
        return minIndex;
    }

    private double sliceAverage(int[] A, int start, int end) {
        double sum = 0;
        for (int index = start; index < end + 1 ; index++) {
            sum += A[index];
        }
        return sum / (double)((end - start) + 1);
    }


    public int solution0(int[] A) {
        int lastIndex = A.length -1;
        long sum = A[lastIndex];
        double minAvg = Double.MAX_VALUE;
        int minIndex = lastIndex;
        double currentAvg = 0;
        for (int index = lastIndex-1; index > -1 ; index--) {
            sum += A[index];
            currentAvg = sum / (double)(lastIndex - index + 1);
            if(currentAvg <= minAvg) {
                minAvg = currentAvg;
                minIndex = index;
            }

        }
        return minIndex;
    }



    private int[] randomSequence() {
        Random generator = new Random();
        int size = generator.nextInt(MAX_SIZE);
        int[] A = generator.ints(size, MIN_NUMBER, MAX_NUMBER + 1).toArray();
        System.out.println("Array size: " + A.length);
        return A;
    }


    private void testWithRandomValues() {
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println("Iteration # " + i);
            int[] randomSequence = randomSequence();
            int result = solution(randomSequence);
            int expectedResult = calculateIndex(randomSequence);
            if(result != expectedResult) {
                test(randomSequence,expectedResult);
                break;
            }
        }
    }


    public void test(int[] A, int expectedResult) {
        int result = solution(A);
        System.out.println(Arrays.toString(A));
        System.out.println(result);
        System.out.println(expectedResult == result);
        System.out.println(calculateIndex(A));

    }

    public int calculateIndex(int[] A) {
        Double[] avg = new Double[A.length];
        int lastIndex = A.length -1;
        long sum = A[lastIndex];
        avg[lastIndex] = new Double(sum);
        for (int index = A.length -2; index > -1; index--) {
            sum += A[index];
            avg[index] = sum / (double)(lastIndex - index + 1);
        }


        avg[lastIndex] = Double.MAX_VALUE;
        Double min = Arrays.stream(avg).min(Double::compare).get();
        List<Double> doubles = Arrays.asList(avg);
        int result = Arrays.asList(avg).indexOf(min);
        System.out.printf("Min: [%d] -> %.3f\n",result,min);
//        for (int index = 0; index < A.length; index++) {
//
//            System.out.printf("%s[%d] %d -> %.3f\n",index==result?"\t":"",index,A[index], avg[index]);
//        }
        return result;
    }
}
