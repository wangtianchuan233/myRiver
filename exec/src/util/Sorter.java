package util;

/**
 * @author wangtianchuan 2021/8/10
 * 
 * 基本排序方法
 *  1 堆排序
 *  2 基数排序
 *  3 希尔排序
 *  4 快速排序
 *  5 选择排序
 *  6 冒泡排序
 *  7 归并排序
 *  8 插入排序
 */
public class Sorter {

    private Sorter() {
    }

    /**
     * 堆排序
     *
     * @param arr int 数组
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for(int i = (n >> 1) - 1; i >= 0; i--){
            // 构建初始大顶堆
            adjustHeap(arr, i, n);
        }
        for(int i = arr.length - 1; i >= 0; i--){
            // 堆顶元素最大, 堆尾元素不知道, 交换堆顶堆尾元素, 把最大元素放到堆尾
            swap(arr, 0, i);
            if (i > 0) {
                // 摘除堆尾元素, 再次构建大顶堆
                adjustHeap(arr, 0, i - 1);
            }
        }
    }

    /**
     * 基数排序
     *
     * @param arr int 数组
     */
    public static void radixSort(int[] arr) {

    }

    /**
     * 希尔排序
     *
     * @param arr int 数组
     */
    public static void shellSort(int[] arr){

    }

    /**
     * 快速排序
     *
     * @param arr int 数组
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 选择排序
     *
     * 对于长度为 n 的数组, 进行 n * (n - 1) / 2 次比较,
     * 最坏的情况需要进行 (n - 1) 次交换位置;
     * 最好的情况不需要进行交换位置;
     * 时间复杂度 O (n^2)
     * 空间复杂度 O (1)
     *
     * @param arr int 数组
     */
    public static void selectSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = arr.length - 1;
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }
    }

    /**
     * 冒泡排序
     *
     * 对于长度为 n 的数组, 进行 n * (n - 1) / 2 次比较,
     * 最坏的情况需要进行 n * (n - 1) / 2 次交换位置;
     * 最好的情况不需要进行交换位置;
     * 时间复杂度 O (n^2)
     * 空间复杂度 O (1)
     *
     * @param arr int 数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 归并排序
     *
     * 需要把数组一步步的拆分为长度减半的子数组(逻辑拆分, 不生成新的数组)
     * 再从一个个长度为 1 的数组中合并回原数组;
     * 每个合并过程都需要借助一个临时数组;
     * 空间复杂度为 O(n)
     * 时间复杂度为 O(n * log n)
     * @param arr int 数组
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2){
            return;
        }
        msSort(arr, 0, arr.length - 1);
    }

    /**
     * 插入排序
     *
     * 最坏的情况需要进行 n * (n - 1) / 2 次比较, 进行 (n - 1) 次规模从 1 到 n - 1 的数组移动;
     * 最好的情况只需要进行 n - 1 次比较;
     * 时间复杂度为 O(n^2)
     * 空间复杂度为 O(1)
     *
     * @param arr int 数组
     */
    public static void insertSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    /*
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     *                     以下均为 private 方法
     * ---------------------------------------------------------------
     */
    private static void msSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        msSort(arr, l, mid);
        msSort(arr, mid + 1, r);
        msMerge(arr, l, mid, mid + 1, r);
    }

    private static void msMerge(int[] arr, int a1, int a2, int b1, int b2) {
        /*
            把 arr 数组中 a1 ~ a2 下标视为数组 1, b1 ~ b2 下标视为数组 2;
            合并这两个数组; 按照 msSort 的拆分逻辑, 有: a2 + 1 = b1
         */
        // 创建临时数组, 用于本次合并, 本次需要合并的数组长度为 n
        int n = b2 - a1 + 1;
        int[] temp = new int[n];
        int index = 0;
        while(a1 <= a2 && b1 <= b2){
            if (arr[a1] < arr[b1]){
                temp[index] = arr[a1];
                a1++;
            } else {
                temp[index] = arr[b1];
                b1++;
            }
            index++;
        }
        while(a1 <= a2){
            temp[index++] = arr[a1++];
        }
        while(b1 <= b2){
            temp[index++] = arr[b1++];
        }
        // 把临时数组 temp 中的元素复制到 arr 数组中 a1 ~ b2 的位置上
        while(n >= 1){
            arr[b2--] = temp[--n];
        }
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int a = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            // 从右侧开始, 找到第一个小于基准数的数字 B
            while (i < j && arr[j] >= a) {
                j--;
            }
            // 从左侧开始, 找到第一个大基准数的数字 A
            while (i < j && arr[i] <= a) {
                i++;
            }
            // 如果 A 在 B 的左侧, 就交换 A, B 的位置;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        /*
         把基准数字放到一个合适的位置, 以保证: 经过本轮排序以后,
         基准数字左边的数全都小于等于它;
         基准数字右边的数全都大于等于它;
         为了保证这里拿到准确的 i 的值, 上面的 while 循环,
         必须先确定 j 的值, 再确定 i 的值;
         */
        swap(arr, l, i);
        quickSort(arr, l, i - 1);
        quickSort(arr, j + 1, r);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int n) {
        int temp = arr[i];
        for(int k = (i << 1) + 1; k < n; k = (k << 1) + 1){
            if ((k + 1) < n && arr[k] < arr[k + 1]){
                k++;
            }
            if (arr[k] > arr[i]){
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }
}
