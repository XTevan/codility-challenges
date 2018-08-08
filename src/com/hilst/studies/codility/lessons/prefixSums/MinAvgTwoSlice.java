package com.hilst.studies.codility.lessons.prefixSums;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        MinAvgTwoSlice runner = new MinAvgTwoSlice();
//        runner.test(new int[]{1,2},0);
//        runner.test(new int[]{2,2},0);
//
//        runner.test(new int[]{1, 2, 3, 4}, 0);
//        runner.test(new int[]{4, 3, 2, 1}, 2);
//        runner.test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);
//        runner.test(new int[]{4, 2, 2, 5, 1, 5, 8}, 1);
//
//        runner.test(new int[]{-9956, 3034, -4424, 6561, 9007, -7514, -9847, -4299, -5125, 3325, 7004, -7824, 1360, -3583,
//                -7231, -143, 4950, -4086, 6039, 2273, -2298, -6791, -7366, 163, 3239, 6901, 4278, 3846, 2620, -6634, 8555,
//                -2001, 1557, -4417, -2408, -6203, -6380, -3455, -4845, -291, 6246, 8472, -6206, 6488}, 5);
//        runner.test(new int[]{1991, 7374, -2033, 8696, 3862, 2832}, 0);


        runner.testWithRandomValues();
    }

    private static final int MAX_SIZE = 100_000;
    private static final int MAX_NUMBER = 10_000;

    private static final int MIN_NUMBER = -MAX_NUMBER;

    public int solution(int[] A)
    {
        Instant init = Instant.now();
        int minIndex = 0;
        double minAvg = Double.MAX_VALUE;
        double currentAvg = 0;
        int maxGroupSize = 4;
        int count = 0;


        for (int index = 0; index < A.length; index++) {
            count = A[index];
            for (int lookAhead = 1; lookAhead < maxGroupSize && (index + lookAhead < A.length); lookAhead++) {
                count += A[index + lookAhead];
                currentAvg = count / (double)(lookAhead + 1);
                if(currentAvg < minAvg) {
                    minAvg = currentAvg;
                    minIndex = index;
                }
            }
        }

        Instant finish = Instant.now();

        System.out.println("Elapsed: " + Duration.between(init,finish));
        System.out.printf("Min: [%d] -> %f\n", minIndex, minAvg);
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
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.println("Iteration # " + i);
            int[] randomSequence = randomSequence();
            int result = solution(randomSequence);
            int expectedResult = calculateIndex(randomSequence);
            if (result != expectedResult) {
//                test(randomSequence, expectedResult);
                break;
            }
            System.out.println();
        }
    }


    public void test(int[] A, int expectedResult) {
        System.out.println();
        int result = solution(A);
        expectedResult = calculateIndex(A);
        System.out.println(Arrays.toString(A));
        System.out.println(expectedResult == result);
        System.out.println();

    }

    public int calculateIndex(int[] A) {

        Instant init = Instant.now();

        int groupNum = 3;

        // write your code in Java SE 8
        int valueSums[] = new int[groupNum]; //(A[N-1] + A[N-2]);
        int indexSums[] = new int[groupNum]; // = 2;

        int startIndex = 0; // = N-2;
        float minAverage = 10000f; // Max value of entrance

        // Goes through all the elements of A
        for (int iElement = 0; iElement < A.length; iElement++)
        {
//            System.out.print("Element ");
//            System.out.print(iElement);
//            System.out.print(" - ");

            // Initialize array elements Value Sums
            if (iElement == 0)
                valueSums[iElement] += A[iElement];
            else
            {
                // Ensures the array length and initialize conjunct
                if (iElement < groupNum)
                    valueSums[iElement] += valueSums[iElement - 1] + A[iElement];

                int groupNums = iElement < groupNum ? iElement : groupNum;

                // Conjunct groups, starting from conjunt with 2 elements
                for (int iConj = 0; iConj < groupNums; iConj++)
                {
                    // Defines number of elements of this conjunct
                    int nElements = iConj + 2;

                    // If current element is ahead of number of elements of conjunct, remove element surplus
                    if (iElement - nElements >= 0)
                        valueSums[iConj] -= A[iElement - nElements];

                    // Add current element
                    valueSums[iConj] += A[iElement];

                    //                System.out.print(valueSums[iConj] / (float)nElements);
                    //                System.out.print(", ");

                    // Verifies current average
                    if (valueSums[iConj] / (float)nElements < minAverage)
                    {
                        // Apply if is smaller than current one
                        minAverage = valueSums[iConj] / (float)nElements;
                        // Saves start index
                        startIndex = iElement - nElements + 1;
                    }
                }
            }
//            System.out.println("");
        }


        Instant finish = Instant.now();

        System.out.println("Elapsed: " + Duration.between(init,finish));
        System.out.printf("Min: [%d] -> %f\n", startIndex, minAverage);
        return startIndex;

    }

}
