package exercise.easy;

/**
 * @author wangtianchuan
 * 
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，
 * 每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 *
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * 给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i个三明治的类型（i = 0是栈的顶部），
 * students[j]是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1700 {

    public static void main(String[] args) {

    }

    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for(int i = 0; i < students.length; i++){
            count[students[i]]++;
        }
        for(int i = 0; i < sandwiches.length; i++){
            if (count[sandwiches[i]] == 0){
                break;
            }
            count[sandwiches[i]]--;
        }
        return count[0] + count[1];
    }
}
