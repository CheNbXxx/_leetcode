package top.chenqwwq.archive.$20200418.daily;

/**
 * 999. 车的可用捕获量
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 在本例中，车能够捕获所有的卒。
 * 示例 2：
 * <p>
 * 输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：0
 * 解释：
 * 象阻止了车捕获任何卒。
 * 示例 3：
 * <p>
 * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * 输出：3
 * 解释：
 * 车可以捕获位置 b5，d6 和 f5 的卒。
 * <p>
 * 提示：
 * <p>
 * board.length == board[i].length == 8
 * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 * 只有一个格子上存在 board[i][j] == 'R'
 *
 * @author chen
 * @date 2020/3/26 上午9:34
 */
public class $0026 {
    class Solution {
        private static final char CHE = 'R';

        private static final char XIANG = 'B';

        private static final char ZU = 'p';

        public int numRookCaptures(char[][] board) {
            // 找到车的位置
            int i = -1, j = -1;
            outer:
            for (int q = 0; q < board.length; q++) {
                for (int p = 0; p < board[0].length; p++) {
                    if (board[q][p] == CHE) {
                        i = q;
                        j = p;
                        break outer;
                    }
                }
            }

            int res = 0;

            for (int q = i; q >= 0; q--) {
                if (board[q][j] == XIANG) {
                    break;
                }
                if (board[q][j] == ZU) {
                    res++;
                    break;
                }
            }
            for (int q = i; q < board.length; q++) {
                if (board[q][j] == XIANG) {
                    break;
                }
                if (board[q][j] == ZU) {
                    res++;
                    break;
                }
            }

            for (int q = j; q < board[0].length; q++) {
                if (board[i][q] == XIANG) {
                    break;
                }
                if (board[i][q] == ZU) {
                    res++;
                    break;
                }
            }

            for (int q = j; q >= 0; q--) {
                if (board[i][q] == XIANG) {
                    break;
                }
                if (board[i][q] == ZU) {
                    res++;
                    break;
                }
            }

            return res;

        }
    }
}
