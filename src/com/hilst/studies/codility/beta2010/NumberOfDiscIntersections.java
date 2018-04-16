package com.hilst.studies.codility.beta2010;

public class NumberOfDiscIntersections {
    public int solution(int[] A) {
        int pairs = 0;

        for (int currentCircleCenter = 0; currentCircleCenter < A.length -1 && !hasReachedLimit(pairs); currentCircleCenter++) {
            for (int otherCircleCenter = currentCircleCenter + 1; otherCircleCenter < A.length && !hasReachedLimit(pairs); otherCircleCenter++) {
                if(checkIntersection(A,currentCircleCenter,otherCircleCenter)) {
                    pairs++;
                    System.out.println(String.format("Intersection of circles: (%d,%d) and (%d,%d)",currentCircleCenter,A[currentCircleCenter],otherCircleCenter,A[otherCircleCenter]));
                }
            }
        }
        return hasReachedLimit(pairs) ? -1 : pairs;
    }

    private boolean hasReachedLimit(int pairs) {
        return pairs > 10000000;
    }
    private boolean checkIntersection(int[] A,int centerA, int centerB) {
        boolean result = false;
        Long radiusB = new Long(A[centerB]);
        Long radiusA = new Long(A[centerA]);
        Long radiusSum = radiusA + radiusB;
        int centerDistance = Math.abs(centerA - centerB);
        result = centerDistance <= radiusSum
                || centerDistance <= Math.abs(radiusA - radiusB);
        return result;
    }
}
