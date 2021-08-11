package exercise.lc.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *   第 0 行   1
 *   第 1 行   1  1
 *   第 2 行   1  2  1
 *   第 3 行   1  3  3   1
 *   第 4 行   1  4  6   4   1
 *   第 5 行   1  5  10  10  5  1
 *
 *
 */
public class Title119 {
    public static void main(String[] args) {
        System.out.println(new Title119().getRow(5));
        //System.out.println(new Title119().c(3,1));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 2){
            for(int i = 0; i <= rowIndex; i++){
                list.add(1);
            }
        } else {
            int[] arr = getArr(rowIndex);
            for (int a : arr) {
                list.add(a);
            }
        }
        return list;
    }

    /**
     * @param rowIndex >= 2
     * @return
     */
    private int[] getArr(int rowIndex) {
        final int[] ints = new int[rowIndex + 1];
        ints[0] = ints[1] = 1;
        for(int i = 2; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                ints[j] = ints[j] + ints[j - 1];
            }
        }
        return ints;
    }
}
