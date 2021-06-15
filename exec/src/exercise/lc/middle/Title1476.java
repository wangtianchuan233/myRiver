package exercise.lc.middle;

/**
 * @author wangtianchuan
 *
 * 请你实现一个类SubrectangleQueries，它的构造函数的参数是一个 rows x cols的矩形（这里用整数矩阵表示），并支持以下两种操作：
 *
 * 1.updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * 用newValue更新以(row1,col1)为左上角且以(row2,col2)为右下角的子矩形。
 * 2.getValue(int row, int col)
 *
 * 返回矩形中坐标 (row,col) 的当前值。
 * 
 * 最多有500次updateSubrectangle 和getValue操作。
 * 1 <= rows, cols <= 100
 * rows ==rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subrectangle-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subrectangle-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1476 {

}

class SubrectangleQueries {

    private int[][] value;

    public SubrectangleQueries(int[][] rectangle) {
        this.value = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1; i <= row2; i++){
            for(int j = col1; j <= col2; j++){
                value[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return value[row][col];
    }
}
