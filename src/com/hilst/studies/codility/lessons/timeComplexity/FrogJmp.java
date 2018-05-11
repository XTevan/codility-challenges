package com.hilst.studies.codility.lessons.timeComplexity;

public class FrogJmp {
    public static void main(String[] args) {

        int X = 10;
        int Y = 85;
        int D = 30;

        System.out.println(new FrogJmp().solution(X,Y,D));
    }
    public int solution(int X, int Y, int D) {
        return new Double(Math.ceil((new Double(Y) - new Double(X)) / new Double(D))).intValue();
    }
}
