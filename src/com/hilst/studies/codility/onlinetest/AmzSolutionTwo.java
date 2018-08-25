package com.hilst.studies.codility.onlinetest;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmzSolutionTwo {
    public static void main(String[] args) {
        AmzSolutionTwo runner = new AmzSolutionTwo();

        runner.test("BABABA","BABABA");
        runner.test("ACCAABBC","AC");
        runner.test("AABBCC","");
        runner.test("ABCBBCBA","");

    }
    public void test(String S, String expectedValue) {
        System.out.println("S: " + S);
        System.out.println("Expected value:" + expectedValue);

        String result = solution(S);
        boolean equalValues = result.equals(expectedValue);
        System.out.println(equalValues);
        if(!equalValues)
            System.out.println("Result:" + result);
        System.out.println();
    }

    public String solution(String S) {
        StringBuilder builder = new StringBuilder(S);
        Pattern pattern = Pattern.compile("A{2}|B{2}|C{2}");
        Matcher matcher = pattern.matcher(builder);

        do{
            builder = new StringBuilder(matcher.replaceAll(""));
            matcher = pattern.matcher(builder);
        }while(matcher.find());

        return builder.toString();
    }
}
