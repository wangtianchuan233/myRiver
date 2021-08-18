package test.util;

import util.Printer;

/**
 * @author wangtianchuan 2021/8/18
 */
public class PrinterTest {
    public static void main(String[] args) {
        Integer[][] matrix = {{1,2,3},{3,4,5}};
        Printer.printArrayAsMatrix(matrix);
    }
}
