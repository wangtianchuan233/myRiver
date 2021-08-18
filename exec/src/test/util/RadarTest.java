package test.util;

import util.Radar;
import util.Sorter;

/**
 * @author wangtianchuan 2021/8/16
 */
public class RadarTest {
    public static void main(String[] args) {
        binarySearchTest();
    }

    private static void binarySearchTest() {
        int[] arr = {1, 3, 4, 6, 243, 23, 42, 36, 2, 5, 14, 8, 6, 5, 6, 34, 1};
        Sorter.shellSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            System.out.print(Radar.binarySearch(arr, i) + "\t");
        }
    }
}
