package com.hilst.studies.codility.lessons;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
    public static void main(String[] args) {
        Integer[] a = {1,5,2,1,4,0};
//        int[] a = {1, 2147483647, 0};
        Integer biggestGap = 0;

        String binaryNumber = "";
        for (int i = 0; i < 29; i++) {
            binaryNumber += '0';
            int number = Integer.parseInt(String.format("1%s1",binaryNumber),2);
            biggestGap = Math.max(biggestGap,solution(number));
            System.out.println(number);
            System.out.println(biggestGap);
        }
    }

    public static int solution(int N) {
        int result = 0;
        String binaryRepresentation = Integer.toBinaryString(N);
        List<Integer> positionOfOnes = new ArrayList<>();
        for (int index = 0; index < binaryRepresentation.length(); index++) {
            if (binaryRepresentation.charAt(index) == '1') {
                positionOfOnes.add(index);
            }
        }

        if (positionOfOnes.size() > 1) {
            for (int one = 0; one < positionOfOnes.size() -1; one++) {
                result = Math.max(result, positionOfOnes.get(one + 1) - positionOfOnes.get(one) -1);
            }
        }
        else
            return 0;

        return result;
    }
}
