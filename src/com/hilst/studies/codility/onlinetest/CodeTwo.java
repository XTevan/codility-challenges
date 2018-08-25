package com.hilst.studies.codility.onlinetest;

public class CodeTwo {
    public static void main(String[] args) {

    }

    public int[] solution(int[] T) {
        int[] result = new int[T.length -1];
        int[] cities = new int[T.length];
        int capital = -1;
        for (int index = 0; index < T.length; index++) {
            cities[T[index]]++;
            if(T[index] == index)
                capital = index;
        }

        result[0] = cities[capital];

        for (int index = 1; index < result.length; index++) {

        }
        return result;
    }
}
