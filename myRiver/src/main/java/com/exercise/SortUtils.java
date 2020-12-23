package com.exercise;

/**
 * 村口儿王富贵
 * 2020/12/20 0020
 */
public class SortUtils {
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
     * 选择排序
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void selectSort(T[] array) {
		
		for(int i = 0; i < array.length; i++ ){
			int minIndex = i;
			for(int j = array.length - 1; j > 0; j--){
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
     * 冒泡排序
     * @param array
     * @param <T>
     */
    public static <T extends Comparable> void bubbleSort(T[] array){
		
    }

}
