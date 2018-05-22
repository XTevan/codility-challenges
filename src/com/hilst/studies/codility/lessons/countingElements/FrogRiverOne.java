package com.hilst.studies.codility.lessons.countingElements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {
        int[] A = {1,3,1,4,2,3,5,4};
        int X = 5;
        new FrogRiverOne().test(X,A);
    }

    public void test(int X, int[] A) {
        System.out.println(Arrays.toString(A));
        System.out.println("X: "+X);
        System.out.println(this.solution(X,A));
    }

    public int solution(int X, int[] A) {
        int result = -1;
        Set<Integer> fallenLeaves = new HashSet<>();
        for (int index = 0; index < A.length; index++) {
            if(!fallenLeaves.contains(A[index])) {
                fallenLeaves.add(A[index]);
            }
            if(fallenLeaves.size() == X) {
                result = index;
                break;
            }
        }
        return result;
    }
}
