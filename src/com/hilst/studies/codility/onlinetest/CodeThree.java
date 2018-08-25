package com.hilst.studies.codility.onlinetest;

public class CodeThree {
    public static void main(String[] args) {
        CodeThree runner = new CodeThree();

        runner.test(new int[]{29,50},new int[]{61,37}, new int[]{37,70},3);
        runner.test(new int[]{29,29},new int[]{61,61}, new int[]{70,70},8);
        runner.test(new int[]{5},new int[]{5}, new int[]{5},0);

    }

    public void test(int[] A, int[] B, int[] C, int expectedResult) {
        System.out.println(solution(A,B,C) == expectedResult);
        System.out.println(expectedResult);
    }

    public int solution(int[] A, int[] B, int[] C) {

        int count = 0;
        for (int indexA = 0; indexA < A.length; indexA++) {
            for (int indexB = 0; indexB < B.length; indexB++) {
                if(B[indexB] > A[indexA]) {
                    for (int indexC = 0; indexC < C.length; indexC++) {
                        if(C[indexC] > B[indexB])
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
