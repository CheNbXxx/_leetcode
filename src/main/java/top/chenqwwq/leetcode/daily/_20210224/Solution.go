package _20210224

/**
 * @author chen
 * @date: 2021/2/24 下午10:10
 * @description:
 *
 */
/*
832. 翻转图像
给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
示例 1：
输入：[[1,1,0],[1,0,1],[0,0,0]]
输出：[[1,0,0],[0,1,0],[1,1,1]]
解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

示例 2：
输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

提示：
1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
*/

func flipAndInvertImage(A [][]int) [][]int {
	// [[1,1,0],]
	//  [1,0,1],
	//  [0,0,0]]
	n := len(A)
	if n == 0 {
		return A
	}

	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}

	m := n - 1
	q := n >> 1
	for j := 0; j < n; j++ {
		for i := 0; i < q; i++ {
			res[j][i] = A[j][m-i] ^ 1
			res[j][m-i] = A[j][i] ^ 1
		}
		// 奇数
		if n&1 == 1 {
			res[j][q] = A[j][q] ^ 1
		}
	}

	return res
}
