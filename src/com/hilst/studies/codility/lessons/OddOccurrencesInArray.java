package com.hilst.studies.codility.lessons;

import java.util.Arrays;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = {9,3,9,3,9,7,9};
        System.out.println(Arrays.toString(A));
        System.out.println(new OddOccurrencesInArray().solution(A));
    }
    public int solution(int[] A) {
        int result = A.length == 1 ? A[0] : A[A.length -2];
        int index = 0;
        while (index < A.length -2) {
            if(A[index] != A[index + 2] ){
                result = A[index];
                break;
            }
            index += index % 2 == 0 ? 1 : 3;
        }
        return result;
    }
}
