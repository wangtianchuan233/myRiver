package test.util;

import util.Sorter;

import java.util.Arrays;

/**
 * @author wangtianchuan 2021/8/11
 */
public class SorterTest {
    public static void main(String[] args) {
        /*int[] arr0 = {2,4,6,3,2};
        sort(arr0);
        System.out.println(Arrays.toString(arr0));
        int[] arr1 = {1};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {};
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {6,5,3,2,1,1,1,1};
        sort(arr3);
        System.out.println(Arrays.toString(arr3));*/
        sort();
    }
    static void sort(){
        int[] arr4 = new int[]{3,1,4,6,5234,1231,123,53,7646,63,1,4213,45,21,432};
        Sorter.heapSort(arr4);
        System.out.println(Arrays.toString(arr4));
    }
}
