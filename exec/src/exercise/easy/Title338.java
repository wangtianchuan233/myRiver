package exercise.easy;

import java.util.Arrays;

/**
 * @author wangtianchuan
 */
public class Title338 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(new Title338().countBits(n)));
    }
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        if(n == 1){
            return res;
        }
        int i = 1;
        int l = 2, r = 3;
        while((r <= n)){
            for(int k = l; k <= r; k++){
                res[k] = 1 + res[k - l];
            }
            i++;
            l = 2 << i - 1;
            r = (2 << i) - 1;
        }
        for(int k = l; k <= n; k++){
            res[k] = 1 + res[k - l];
        }
        return res;
    }
}
