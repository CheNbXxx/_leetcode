package top.chenbxxx.common;

/**
 * 36. 有效的数独
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ['8','3','.','.','7','.','.','.','.'],
 *   ['6','.','.','1','9','5','.','.','.'],
 *   ['.','9','8','.','.','.','.','6','.'],
 *   ['8','.','.','.','6','.','.','.','3'],
 *   ['4','.','.','8','.','3','.','.','1'],
 *   ['7','.','.','.','2','.','.','.','6'],
 *   ['.','6','.','.','.','.','2','8','.'],
 *   ['.','.','.','4','1','9','.','.','5'],
 *   ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * [".",".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".",".","."],
 * [".","9",".",".",".",".",".",".","1"],
 * ["8",".",".",".",".",".",".",".","."],
 * [".","9","9","3","5","7",".",".","."],
 * [".",".",".",".",".",".",".","4","."],
 * [".",".",".","8",".",".",".",".","."],
 * [".","1",".",".",".",".","4",".","9"],
 * [".",".",".","5",".","4",".",".","."]
 *
 * @author bingxin.chen
 * @date 2019/7/23 12:04
 */
public class Leetcode36 {
    public static void main(String[] args) {
        System.out.println(new Leetcode36().new Solution().isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '9', '.', '.', '.', '.', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '9', '9', '3', '5', '7', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '4', '.'},
                {'.', '.', '.', '8', '.', '.', '.', '.', '.'},
                {'.', '1', '.', '.', '.', '.', '4', '.', '9'},
                {'.', '.', '.', '5', '.', '4', '.', '.', '.'}}));
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 双层遍历9*9的二维数组,在一次遍历之内完成校验
            final int length = board.length;
            boolean[][] sign = new boolean[length * 3][length];

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    // 取值
                    int ti = Character.getNumericValue(board[i][j]) - 1;

                    // 确定子数独的排序
                    int index = (i / 3) * 3 + j / 3 + 2 * length;

                    if (sign[i][ti] || sign[j + length][ti] || sign[index][ti]) {
                        return false;
                    }

                    // 横向
                    sign[i][ti] = true;
                    // 纵向
                    sign[j + length][ti] = true;
                    // 子数独
                    sign[index][ti] = true;
                }
            }
            return true;
        }
    }
}
