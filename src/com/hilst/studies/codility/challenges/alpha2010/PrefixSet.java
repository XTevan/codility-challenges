package com.hilst.studies.codility.challenges.alpha2010;

import java.util.HashSet;
import java.util.Set;

public class PrefixSet {

    public static void main(String[] args) {
        int[] a = {2,2,1,0};
//        int[] a = {1, 2147483647, 0};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int index = 0;
        Set<Integer> prefix = new HashSet<>();
        for (int c = 0 ; c < A.length; c++) {
            if(!prefix.contains(A[c])) {
                prefix.add(A[c]);
                index = c;
            }
        }
        return index;
    }
}
