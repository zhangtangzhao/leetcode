//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 771 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 * @author zhangtangzhao
 * @date 2022-06-19 20:17:42
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
	 }
	 
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
		HashMap<Integer,Integer> inorderMap = new HashMap<>();
		int[] post;
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			for (int i = 0; i < inorder.length ; i++) {
				inorderMap.put(inorder[i], i );
			}
			post = postorder;

			TreeNode root = buildTree(0, inorder.length - 1, 0 , postorder.length - 1);
			return root;
		}

		public TreeNode buildTree(int inorderStart, int inorderEnd , int postorderStart, int postorderEnd) {
			if ( inorderEnd < inorderStart || postorderEnd < postorderStart) {
				return null;
			}

			int root = post[postorderEnd];
			int rootIndex = inorderMap.get(root);
			TreeNode node = new TreeNode(root);
			node.left = buildTree(inorderStart,rootIndex - 1, postorderStart, postorderStart + rootIndex - inorderStart - 1);
			node.right = buildTree(rootIndex + 1, inorderEnd, postorderStart + rootIndex - inorderStart, postorderEnd - 1);
			return node;

		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
