package com.hilst.studies.codility.lessons.countingElements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static void main(String[] args) {
        int[] valid = {4,1,3,2};
        int[] invalid = {4,1,3};
        int[] singleValid = {1};
        int[] singleInvalid = {2};
        PermCheck runner = new PermCheck();
        runner.test(valid);
        runner.test(invalid);
        runner.test(singleValid);
        runner.test(singleInvalid);
    }

    public void test(int[] input) {
        System.out.println(Arrays.toString(input));
        System.out.println(this.solution(input));
    }

    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();
        for (int index = 0; index < A.length; index++) {
            numbers.add(A[index]);
        }
        int result = 1;
        for (int index = 1; index <= A.length; index++) {
            if(!numbers.contains(index)) {
                result = 0;
                break;
            }
        }
        return result;
    }
}
