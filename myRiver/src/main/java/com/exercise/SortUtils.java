package com.exercise;

/**
 * 村口儿王富贵
 * 2020/12/20 0020
 */
public class SortUtils {
    public static <T extends Comparable> void quickSort(T[] array,int left,int right){
        int i = left, j = right;
        T middle = array[(i + j) / 2];

        do{
            while(array[i].compareTo(middle) < 0 && i < right){
                i++;
            }
            while(array[j].compareTo(middle) > 0 && j > left){
                j--;
            }
            if (i <= j){
                T tem = array[i];
                array[i] = array[j];
                array[j] = tem;
                i++;
                j--;
            }
        }while(i < j);
        if (i < right){
            quickSort(array,i,right);
        }
        if (j > left){
            quickSort(array,left,j);
        }
    }
    public static <T extends Comparable> void selectSort(T[] array){

    }

    public static <T extends  Comparable> void guluSort(T[] array){

    }
}
