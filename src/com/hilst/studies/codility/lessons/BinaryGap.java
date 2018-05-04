package com.hilst.studies.codility.lessons;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
    public int solution(int N) {
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
