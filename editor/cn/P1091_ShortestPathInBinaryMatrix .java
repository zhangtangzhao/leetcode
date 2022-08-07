//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 210 👎 0


package leetcode.editor.cn;

/**
 * 二进制矩阵中的最短路径
 * @author zhangtangzhao
 * @date 2022-08-07 21:23:01
 */
public class P1091_ShortestPathInBinaryMatrix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1091_ShortestPathInBinaryMatrix().new Solution();
	 }
	 
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if(grid[0][0] == 1 || grid[n-1][n-1] == 1){  // 只有两端都是0才可以开始
                return -1;
            }
            int count = 0;
            int[] dx = {0,1,0,-1,1,-1,1,-1};
            int[] dy = {1,0,-1,0,1,-1,-1,1}; // 8个位置
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            grid[0][0] = 1; // 走过的标记为1，这样就可以走最短的了
            while(!queue.isEmpty()){ // 进入BFS
                int size = queue.size();
                count++;
                for(int i = 0; i < size; i++){ // 逐层搜索
                    int[] tmp = queue.poll();
                    int x = tmp[0];
                    int y = tmp[1];
                    if(x == n-1 && y == n-1){ // 到达终点就返回
                        return count;
                    }
                    for(int k = 0; k < 8; k++){
                        int xx = x + dx[k];
                        int yy = y + dy[k];
                        if(xx >= 0 && xx < n && yy >= 0 && yy < n && grid[xx][yy] == 0){  // 加入下一层的数
                            queue.offer(new int[]{xx,yy});
                            grid[xx][yy] = 1;
                        }
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
