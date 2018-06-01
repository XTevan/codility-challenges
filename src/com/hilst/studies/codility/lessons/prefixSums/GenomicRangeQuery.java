package com.hilst.studies.codility.lessons.prefixSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenomicRangeQuery {
    private static final int NO_OCCURRENCE = -1;
    private static final int N_MAX = 1000;
    private static final int M_MAX = N_MAX / 2;
    private static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) {
        GenomicRangeQuery runner = new GenomicRangeQuery();
//        runner.test("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
//        runner.test("G", new int[]{0}, new int[]{0});
//        runner.test("CC", new int[]{0,0,1}, new int[]{0,1,1});
//        runner.test("CGCCTAAGTGCGCGCGATGGTTACGAAATCAGGGGGTCTGACGTTACCCGCCTAACCCAGGATTCTCCTCACAGAAGGGAGCCCCCCTCCTTCATCAGCT", new int[]{31,17}, new int[]{75,65});
        runner.randomSequence();
    }

    private void randomSequence() {
        Random generator = new Random();
        int N = generator.nextInt(N_MAX);
        boolean equalResult = true;
        for (int i = 0; i < N_MAX && equalResult; i++) {
            System.out.println("Iteration: " + i);
            while (N == 0)
                N = generator.nextInt(N_MAX);

            int[] A = generator.ints(N_MAX, 0, 4).toArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length; j++) {
                sb.append(NUCLEOTIDES[A[j]]);
            }
            int M = generator.nextInt(M_MAX);
            int[] P = new int[M], Q = new int[M];
            for (int j = 0; j < M; j++) {
                P[j] = generator.nextInt(sb.length() - 1);

                Q[j] = generator.nextInt(sb.length() - 1 - P[j]) + P[j];
            }
            equalResult = test(sb.toString(), P, Q);
        }

    }

    public boolean test(String S, int[] P, int[] Q) {
        int[] resultF = solution(S, P, Q);
        int[] resultC = solutionA(S, P, Q);
        boolean equalArrays = Arrays.equals(resultF, resultC);
        System.out.println("S: " + S);
        System.out.println("P: " + Arrays.toString(P));
        System.out.println("Q: " + Arrays.toString(Q));
        System.out.println("Rf: " + Arrays.toString(resultF));
        if (!equalArrays) {
            System.out.println("RC: " + Arrays.toString(resultC));
        }

        return equalArrays;
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        List<Integer[]> indexOfOnes = new ArrayList<>();
        List<Integer[]> indexOfTwos = new ArrayList<>();
        List<Integer[]> indexOfThrees = new ArrayList<>();
        int firstOccurence = NO_OCCURRENCE;
        int ocurrences = 0;

        for (int index = 0; index < S.length(); index++) {
            Character c = S.charAt(index);
            if (c < 'G') {
                if (c == 'A') {
                    if (firstOccurence == NO_OCCURRENCE)
                        firstOccurence = index;

                    if (index + 1 < S.length() && c == S.charAt(index + 1)) {
                        ocurrences++;
                    } else {
                        indexOfOnes.add(new Integer[]{firstOccurence, ocurrences});
                        ocurrences = 0;
                        firstOccurence = NO_OCCURRENCE;
                    }

                } else {
                    if (firstOccurence == NO_OCCURRENCE)
                        firstOccurence = index;

                    if (index + 1 < S.length() && c == S.charAt(index + 1)) {
                        ocurrences++;
                    } else {
                        indexOfTwos.add(new Integer[]{firstOccurence, ocurrences});
                        ocurrences = 0;
                        firstOccurence = NO_OCCURRENCE;
                    }


                }
            } else {
                if (c == 'G') {
                    if (firstOccurence == NO_OCCURRENCE)
                        firstOccurence = index;

                    if (index + 1 < S.length() && c == S.charAt(index + 1)) {
                        ocurrences++;
                    } else {
                        indexOfThrees.add(new Integer[]{firstOccurence, ocurrences});
                        ocurrences = 0;
                        firstOccurence = NO_OCCURRENCE;
                    }


                }
            }
        }

        Integer[][] temp = new Integer[][]{};
        Integer[][] ones = indexOfOnes.toArray(temp);
        Integer[][] twos = indexOfTwos.toArray(temp);
        Integer[][] threes = indexOfThrees.toArray(temp);

        for (int index = 0; index < P.length; index++) {
            if (indexOfOnes.size() > 0) {
                result[index] = checkMinimumImpact(ones, P[index], Q[index], 1);

            }

            if (result[index] == 0 && indexOfTwos.size() > 0) {
                result[index] = checkMinimumImpact(twos, P[index], Q[index], 2);
            }

            if (result[index] == 0 && indexOfThrees.size() > 0) {
                result[index] = checkMinimumImpact(threes, P[index], Q[index], 3);
            }
            if (result[index] == 0)
                result[index] = 4;


        }
        return result;
    }

    private Integer checkMinimumImpact(Integer[][] impactLevelIndices, Integer lowerBound, Integer higherBound, Integer impact) {
        Integer result = 0;
        for (Integer[] n : impactLevelIndices) {
            if (n[0] > higherBound)
                break;
            if (n[0] + n[1] >= lowerBound) {
                result = impact;
                break;
            }
        }
        return result;

    }

    public int[] solutionA(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        List<Integer> indexOfOnes = new ArrayList<>();
        List<Integer> indexOfTwos = new ArrayList<>();
        List<Integer> indexOfThrees = new ArrayList<>();


        for (int index = 0; index < S.length(); index++) {
            Character c = S.charAt(index);
            if (c < 'G') {
                if (c == 'A') {
                    indexOfOnes.add(index);
                } else {
                    indexOfTwos.add(index);
                }
            } else {
                if (c == 'G') {
                    indexOfThrees.add(index);
                }
            }
        }

        for (int index = 0; index < P.length; index++) {
            if (indexOfOnes.size() > 0) {
                for (Integer n : indexOfOnes) {
                    if (n > Q[index])
                        break;
                    if (n >= P[index]) {
                        result[index] = 1;
                        break;
                    }

                }
            }

            if (result[index] == 0 && indexOfTwos.size() > 0) {
                for (Integer n : indexOfTwos) {
                    if (n > Q[index])
                        break;
                    if (n >= P[index]) {
                        result[index] = 2;
                        break;
                    }

                }
            }

            if (result[index] == 0 && indexOfThrees.size() > 0) {
                for (Integer n : indexOfThrees) {
                    if (n > Q[index])
                        break;
                    if (n >= P[index]) {
                        result[index] = 3;
                        break;
                    }

                }
            }
            if (result[index] == 0)
                result[index] = 4;


        }
        return result;
    }
}
