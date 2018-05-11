package com.hilst.studies.codility.lessons.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    private static final int FLAG = -1;

    public static void main(String[] args) {
        int[] A = {9,3,9,3,9,7,9};
        //int[] A = {2,2,3,3,4};
        System.out.println(Arrays.toString(A));
        System.out.println(new OddOccurrencesInArray().solutionB(A));
    }
    public int solution(int[] A) {
        int result = A.length == 1 ? A[0] : -1;
        int numberOfOccurrences = 0;
        int current = 0;
        if(result == -1) {
            for (int index = 0; index < A.length; index++) {
                if(A[index] != FLAG) {
                    numberOfOccurrences = 1;
                    current = A[index];

                    for (int forwardIndex = index + 1; forwardIndex < A.length; forwardIndex++) {
                        if (A[forwardIndex] == current) {
                            numberOfOccurrences++;
                            A[forwardIndex] = FLAG;
                        }
                    }
                    if(numberOfOccurrences % 2 != 0) {
                        result = current;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public int solutionB(int[] A ) {//optimal
        int result = A[0];
        Map<Integer,Integer> occurrences = new HashMap<>();
        for (int index = 0; index < A.length; index++) {
            Integer counter = occurrences.get(A[index]);
            if (counter != null)
                occurrences.put(A[index],++counter);
            else
                occurrences.put(A[index],1);
        }
        for (Map.Entry<Integer, Integer> entry: occurrences.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                result = entry.getKey();
                break;
            }

        }
        return result;
    }
}
