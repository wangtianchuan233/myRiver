package test;

import util.Judge;

/**
 * @author wangtianchuan 2021/8/10
 */
public class JudgeTest {
    public static void main(String[] args) {
        int count = 0, i = 1;
        while(count < 26){
            if (Judge.isPrime(++i)){
                System.out.print(i);
                count++;
                System.out.print(",");
            }
        }
    }
    public static String multiply(String num1, String num2) {
        return null;
    }
}
