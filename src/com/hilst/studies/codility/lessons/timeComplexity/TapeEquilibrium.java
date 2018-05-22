package com.hilst.studies.codility.lessons.timeComplexity;

public class TapeEquilibrium {
    public static void main(String[] args) {
        Integer[] A = {3,1,2,4,3};
//        Integer[] A = {2,3};
        System.out.println(new TapeEquilibrium().solution(A));
    }

    public int solution(Integer[] A){
        Long[] partialSum = new Long[A.length];
        Long total = 0l;
        for (int index = 0; index < A.length; index++) {
            partialSum[index] = total += A[index];
        }
        Long result = new Long(Integer.MAX_VALUE);

        for (int index = 0; index < A.length - 1; index++) {
            result = Math.min(result, Math.abs(total - 2 * partialSum[index]));
        }
        return result.intValue();
    }
}
