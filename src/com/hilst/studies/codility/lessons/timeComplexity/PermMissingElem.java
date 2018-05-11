package com.hilst.studies.codility.lessons.timeComplexity;

public class PermMissingElem {
    public static void main(String[] args) {
//        int[] A = {2,3,1,5};
        int[] A = {1,2,3,4};

        System.out.println(new PermMissingElem().solution(A));
    }

    private int solution(int[] A) {
        int[] sortedArray = new int[A.length + 1];
        int result = 1;
        for (int index = 0; index < A.length; index++) {
            sortedArray[A[index]-1] = 1;
        }
        for (int index = 0; index < sortedArray.length; index++) {
            if(sortedArray[index] != 1) {
                result = index + 1;
                break;
            }
        }

        return result;
    }
}
