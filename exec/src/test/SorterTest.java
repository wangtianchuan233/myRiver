package test;

import util.Sorter;

import java.util.Arrays;

/**
 * @author wangtianchuan 2021/8/11
 */
public class SorterTest {
    public static void main(String[] args) {
        int[] arr0 = {2,4,6,3,2};
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
        System.out.println(Arrays.toString(arr3));
    }
    static void sort(int[] arr){
//        Sorter.bubbleSort(arr);
//        Sorter.selectSort(arr);
//        Sorter.insertSort(arr);
//        Sorter.quickSort(arr);
//        Sorter.mergeSort(arr);
//        Sorter.heapSort(arr);
//        Sorter.shellSort(arr);
        Sorter.radixSort(arr);
    }
}
