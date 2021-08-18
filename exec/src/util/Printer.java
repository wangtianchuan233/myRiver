package util;

/**
 * @author wangtianchuan 2021/8/18
 */
public class Printer {

    private Printer(){}

    public static <T extends Object> void printArrayAsMatrix(T[][] arr){
        for (T[] row : arr) {
            for (T col : row) {
                System.out.print(col);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static  void printArrayAsMatrix(int[][] arr){
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void printArrayAsMatrix(boolean[][] arr){
        for (boolean[] row : arr) {
            for (boolean col : row) {
                System.out.print(col);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void printArrayAsMatrix(char[][] arr){
        for (char[] row : arr) {
            for (char col : row) {
                System.out.print(col);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
