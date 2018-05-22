package com.hilst.studies.codility.lessons.countingElements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {
        int[] a = {1,3,6,4,1,2};
        int[] b = {-3,-1};
        int[] c = {1,2,3};
        int[] d = {0};
        MissingInteger runner = new MissingInteger();
        runner.test(a);
        runner.test(b);
        runner.test(c);
        runner.test(d);
    }

    public void test(int[] A) {
        System.out.println(Arrays.toString(A));
        System.out.println(this.solution(A));
    }

    public int solution(int[] A) {
        int result =  A.length + 1;
        Set<Integer> numbers = new HashSet<>();
        for (int index = 0; index < A.length; index++) {
            numbers.add(A[index]);
        }
        for (int index = 1; index <= A.length; index++) {
            if(!numbers.contains(index)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
