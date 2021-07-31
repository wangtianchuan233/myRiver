package exercise.jzoffer;

/**
 * @author wangtianchuan 2021/7/31
 *
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Title12 {
    public static void main(String[] args) {
        Title12 t = new Title12();
        char[][] chars  = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";
//        char[][] chars = {{'a','b'},{'c','d'}};
//        String word = "aba";
//        char[][] chars = {{'a'}};
//        String word = "a";
        System.out.println(t.exist(chars, word));
    }
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (backtrack(board, chars, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] chars, int index, int x, int y) {
        if (chars[index] == board[x][y]){
            index += 1;
            if (index == chars.length){
                return true;
            }
            char tmp = board[x][y];
            board[x][y] = '/';
            boolean ans = false;
            // left
            if (y > 0 && board[x][y - 1] != '/'){
                 ans = ans || backtrack(board, chars, index, x, y - 1);
            }
            // right
            if (y < board[0].length - 1 && board[x][y + 1] != '/'){
                ans = ans || backtrack(board, chars, index, x, y + 1);
            }
            // up
            if (x > 0 && board[x - 1][y] != '/') {
                ans = ans || backtrack(board, chars, index, x - 1, y);
            }
            // down
            if (x < board.length - 1 && board[x + 1][y] != '/') {
                ans = ans || backtrack(board, chars, index, x + 1, y);
            }
            board[x][y] = tmp;
            return ans;
        }
        return false;
    }
}
