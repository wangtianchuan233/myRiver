package exercise.lc.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtianchuan 2021/8/19
 */
public class Title345 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello"));
    }
    static class Solution{
        private Set<Character> vowels;
        public Solution() {
            vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');
        }
        public String reverseVowels (String s){
            char[] chars = s.toCharArray();
            int l = 0, r = chars.length - 1;
            while (l < r) {
                while (l < r && !isVowel(chars[l])) {
                    l++;
                }
                while (l < r && !isVowel(chars[r])) {
                    r--;
                }
                if (l < r) {
                    swap(chars, l, r);
                    l++;
                    r--;
                }
            }
            return new String(chars);
        }

        private boolean isVowel ( char c){
            return vowels.contains(c);
        }

        private void swap ( char[] chars, int l, int r){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
        }
    }
}
