package com.hilst.studies;

import com.hilst.studies.codility.lessons.BinaryGap;

public class Main {

    public static void main(String[] args) {
        Integer[] a = {1,5,2,1,4,0};
//        int[] a = {1, 2147483647, 0};
        Integer biggestGap = 0;
        BinaryGap gapFinder = new BinaryGap();
        String binaryNumber = "";
        for (int i = 0; i < 29; i++) {
            binaryNumber += '0';
            int number = Integer.parseInt(String.format("1%s1",binaryNumber),2);
            biggestGap = Math.max(biggestGap,gapFinder.solution(number));
            System.out.println(number);
            System.out.println(biggestGap);
        }


        //Arrays.stream(a).forEach(x -> System.out.println(x + ": " + Integer.toBinaryString(x)));


    }
}
