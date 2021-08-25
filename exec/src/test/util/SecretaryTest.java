package test.util;

import util.Secretary;

/**
 * @author wangtianchuan 2021/8/24
 */
public class SecretaryTest {
    public static void main(String[] args) {
        String s = "[[1,2],[3],[3],[]]";
        System.out.println(Secretary.bracketToCurly(s));
    }
}
