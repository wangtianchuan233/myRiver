package util;

/**
 * @author wangtianchuan 2021/8/11
 *
 * 查找方法
 */
public class Radar {

    /**
     * find the index of target in an sorted array,
     * return the minimum index if target appears more than once;
     * @param arr an sorted array
     * @param target number to be find
     * @return index of target in arr, -1 if target doesn't exist in the array
     */
    public static int binarySearch(int[] arr, int target){
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    public static int binarySearch(int[] arr, int rangeFrom, int rangeTo, int target){
        int l = rangeFrom, r = rangeTo, mid;
        while(l < r){
            mid = (l + r) / 2;
            if (arr[mid] == target){
                l = r = mid;
            } else if (arr[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] != target) {
            return -1;
        }
        while(l > rangeFrom && arr[l - 1] == target){
            l--;
        }
        return l;
    }

}
