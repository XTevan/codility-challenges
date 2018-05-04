package com.hilst.studies.codility.challenges.beta2010;

public class NumberOfDiscIntersections {

    public static final int MAX_PAIRS = 10000000;

    public static void main(String[] args) {

//        int[] a = {1, 2147483647, 0};
        int[] a = {1,5,2,1,4,0};
        System.out.println(new NumberOfDiscIntersections().solution(a));
    }

    public int solution(int[] A) {
        int pairs = 0;
        int centerDistance = 0;
        Long radiusSum = 0l;

        for (int currentCircleCenter = 0; currentCircleCenter < A.length -1 ; currentCircleCenter++) {
            for (int otherCircleCenter = currentCircleCenter + 1; otherCircleCenter < A.length ; otherCircleCenter++) {
                if(pairs > MAX_PAIRS)
                    return -1;
                radiusSum = new Long(A[otherCircleCenter]) + new Long(A[currentCircleCenter]);
                centerDistance = otherCircleCenter - currentCircleCenter;
                if(centerDistance <= radiusSum) {
                    pairs++;
                    System.out.println(String.format("Intersection of circles: (%d,%d) and (%d,%d)",currentCircleCenter,A[currentCircleCenter],otherCircleCenter,A[otherCircleCenter]));
                }
            }
        }
        return pairs;
    }

}
