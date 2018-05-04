package com.hilst.studies.codility.alpha2010;

import java.util.HashSet;
import java.util.Set;

public class PrefixSet {
    public int solution(int[] A) {
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
