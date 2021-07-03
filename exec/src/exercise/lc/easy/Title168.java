package exercise.lc.easy;

/**
 * @author wangtianchuan 2021/6/29
 * 
 * 给你一个整数columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * 
 *
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title168 {
    public static void main(String[] args) {
        int len = 26 * 100;
        int count = 0;
        for(int i = 1; i <= len; i++){
            System.out.print(initDict(i));
            System.out.print("\t");
            if (++count % 26 == 0){
                System.out.println();
            }
        }
    }
    private static char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static String initDict(int columnNumber){
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 26){
            int index = columnNumber % 26;
            if(index == 0){
                index = 25;
                columnNumber = columnNumber / 26 - 1;
            } else {
                index = index - 1;
                columnNumber /= 26;
            }
            sb.append(letters[index]);
        }
        sb.append(letters[columnNumber - 1]);
        return sb.reverse().toString();
    }
}
