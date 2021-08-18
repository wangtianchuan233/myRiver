package test.util;

import util.Judge;

/**
 * @author wangtianchuan 2021/8/10
 */
public class JudgeTest {
    public static void main(String[] args) {
        palindromeTest();
    }

    private static void palindromeTest() {
        int[] arr = {10};
        for (int i : arr) {
            System.out.println(Judge.isPalindrome(i));
        }
    }
}
