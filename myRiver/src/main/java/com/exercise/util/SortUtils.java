package com.exercise.util;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 村口儿王富贵
 * 2020/12/20 0020
 *
 * 八大排序方法的练习
 *      目前已完成的有：
 *          1、快速排序  2、选择排序  3、简单插入排序    4、冒泡排序
 *          5、归并排序  6、shell排序
 *      剩余：
 *          1、堆排序   2、基数排序
 */
public class SortUtils {
    /**
     * TODO 堆排序
     */

    /**
     * TODO 堆排序调用 --> 调整堆
     */

    /**
     * TODO 基数排序
     */

    /**
     * 归并排序
     */
    public static <T extends Comparable> void mergeSort(T[] array){
        mergeSort(array,0,array.length - 1);
    }
    /**
     * 归并排序
     */
    public static <T extends Comparable> void mergeSort(T[] array,int start, int end){
        if(start < end ){
            int mid = (start + end) / 2;
            mergeSort(array,start,mid);
            mergeSort(array,mid + 1, end);
            merge(array,start,mid,end);
        }
    }
    /**
     *
     */
    /**
     * 归并排序用 --> 合并两个已经排序的数组
     * 数组array,[sta,mid]视为第一个数组,(mid,end]视为第二个数组
     */
    private static <T extends Comparable> void merge(T[] array, int sta, int mid, int end){
//        System.out.println("-----------------------------------------------------");
        /*for (int i = sta; i <= mid; i++) {
            System.out.print(array[i] + ",");
        }*/
//        System.out.println();
        /*for (int i = mid + 1; i <= end; i++) {
            System.out.print(array[i] + ",");
        }*/
//        System.out.println();
        Object[] temp = new Object[array.length];
        int tempIndex = sta;
        int leftIndex = sta;
        int rightIndex = mid + 1;
        while((leftIndex <= mid) && (rightIndex <= end)){
//            System.out.println("leftIndex --->" + leftIndex);
//            System.out.println("mid + 1 --->" + (mid + 1));
//            System.out.println("leftIndex <= (mid + 1) --->" + (leftIndex <= (mid + 1)));
//            System.out.println("start   " + leftIndex + " " +  mid + " " + rightIndex + " " + end);
//            System.out.print("compare: ");
//            System.out.print("array[leftIndex]" + array[leftIndex]);
//            System.out.print("  array[rightIndex]" + array[rightIndex] + "  ");
//            System.out.print(array[leftIndex].compareTo(array[rightIndex]));

            if (array[leftIndex].compareTo(array[rightIndex]) < 0){
//                System.out.println("  plus + " + array[leftIndex]);
                temp[tempIndex] = array[leftIndex];
                leftIndex++;
            }else{
//                System.out.println("plus + " + array[rightIndex]);
                temp[tempIndex] = array[rightIndex];
                rightIndex++;
            }
            tempIndex++;
//            System.out.println("end   " + leftIndex + " " +  mid + " " + rightIndex + " " + end);
        }
        // 如果第一个数列没有检测完,就全部依次存入数组
        while (leftIndex <= mid){
//            System.out.println("left saved");
//            System.out.println("left--------------------------");
//            System.out.println(Arrays.toString(array));
//            System.out.println(Arrays.toString(temp));
//            System.out.println("left--------------------------");
            temp[tempIndex++] = array[leftIndex++];
        }
        // 如果第二个数列没有检测完,就全部依次存入数组
        while (rightIndex <= end){
//            System.out.println("right saved");
//            System.out.println("right--------------------------");
//            System.out.println(Arrays.toString(array));
//            System.out.println(Arrays.toString(temp));
//            System.out.println("right--------------------------");
            temp[tempIndex++] = array[rightIndex++];
        }
//        System.out.print("present  ");
//        System.out.println(Arrays.toString(temp));
        for (int i = sta; i <= end; i++) {
            array[i] = (T) temp[i];
        }
//        System.out.println(Arrays.toString(array));
        /*for (int i = sta; i <= end; i++) {
            System.out.print(array[i] + ",");
        }*/
//        System.out.println();
    }


    /**
     * 希尔排序
     */
    public static <T extends Comparable> void shellSort(T[] array){
        // step 步长,每次缩短步长
        for (int step = array.length / 2; step >= 2; step /= 2){
            // 获取每个步长内的数据
            for (int i = 0; i < array.length - step; i++){
                // 对每个步长内的数据使用简单插入排序算法进行排序
                for (int j = i; j < i + step; j++){
                    int k = 0;
                    T temp = array[j];
                    for (k = j - 1; k >= 0; k--){
                        if (temp.compareTo(array[k]) < 0){
                            array[k + 1] = array[k];
                        }else{
                            break;
                        }
                    }
                    array[k + 1] = temp;
                }
            }
        }
    }

    /**
     * 简单插入排序
     */
    public static <T extends Comparable> void simpleInsertSort(T[] array){
        int j = 0;
        T temp = null;
        for (int i = 0; i < array.length; i++) {
            // 拿到下一个即将被插入的元素
            temp = array[i];
            for (j = i - 1; j >= 0 ; j--) {
                // 把temp和它前面的元素对比,如果它前面的元素比它大,就往后挪一位
                if (array[j].compareTo(temp) > 0){
                    array[j + 1] = array[j];
                }else{
                    // array[j + 1] = temp;
                    break;
                }
            }
            // 把temp插入到指定的位置
            array[j+1] = temp;
        }
    }

    /**
     * 快速排序
     */
    public static <T extends Comparable> void quickSort(T[] array) {
        quickSort(array,0,array.length - 1);
    }

    /**
     * 快速排序
     * 每次选定一个元素作为参考, 假设为A,
     * 经过比较和交换位置,使得A左侧的任意元素都小于A右侧的任意元素,
     * 再分别对A左侧所有元素和A右侧所有元素进行上述操作,
     * 最终使得: 每个元素的左侧所有元素都小于右侧所有元素
     */
    public static <T extends Comparable> void quickSort(T[] array,int left,int right){
        int i = left, j = right;

        // 选定数组中间的元素作为参考(不是必须的选择)
        T middle = array[(i + j) / 2];

        do{
            // 从数组左侧开始遍历,找出第一个不小于middle的元素的下标i
            while(array[i].compareTo(middle) < 0 && i < right){
                i++;
            }
            // 从数组左侧开始遍历,找出第一个不大于middle的元素的下标j
            while(array[j].compareTo(middle) > 0 && j > left){
                j--;
            }
            // 如果i < j,就交换两个元素的位置,使小的在左边,大的在右边
            if (i <= j){
                T tem = array[i];
                array[i] = array[j];
                array[j] = tem;
                i++;
                j--;
            }
            // 在i < j之前重复以上操作, 当 i = j 时, middle左边的元素全部小于等于middle右边的元素
        }while(i < j);

        if (i < right){
            quickSort(array,i,right);
        }
        if (j > left){
            quickSort(array,left,j);
        }
    }

    /**
     * 选择排序:
     */
    public static <T extends Comparable> void selectSort(T[] array) {

		for(int i = 0; i < array.length; i++ ){
			int minIndex = i;
			for(int j = i; j < array.length; j++){
				if(array[j].compareTo(array[minIndex]) < 0){
					minIndex = j;
				}
			}
			if(i != minIndex){
				T temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
    }

    /**
     * 冒泡排序:
     */
    public static <T extends Comparable> void bubbleSort(T[] array){
        for(int i = 0; i < array.length; i++ ){
            for(int j = i; j < array.length; j++){
                if(array[i].compareTo(array[j]) > 0){
                    T temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

}
