package com.hilst.studies.codility.onlinetest;

import java.util.Arrays;

public class AmzSolutionOne {
    public static void main(String[] args) {
        AmzSolutionOne runner = new AmzSolutionOne();
        runner.test(new int[]{1,0,0,1,0,0}, 2);
        runner.test(new int[]{1,1,1,1,1,1,1,1,1,1,1}, 0);
        int[] halfEachSide = new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        runner.test(halfEachSide, halfEachSide.length / 2);
        halfEachSide[0] = 0;
        runner.test(halfEachSide,(halfEachSide.length / 2)-1);
        runner.test(new int[]{1},0);


    }
    public void test(int[] A,  int expectedResult) {
        System.out.println("A: " + Arrays.toString(A));
        System.out.println(expectedResult);

        System.out.println(solution(A) == expectedResult);
    }

    public int solution(int[] A) {
        int countHead = 0;

        for (int index = 0; index < A.length; index++) {
            if(A[index] == 0)
                countHead++;
        }
        int countTail = A.length - countHead;
        return Math.min(countHead,countTail);
    }
}
