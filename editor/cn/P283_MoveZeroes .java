//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1586 👎 0


package leetcode.editor.cn;

/**
 * 移动零
 * @author zhangtangzhao
 * @date 2022-05-15 09:47:33
 */
public class P283_MoveZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P283_MoveZeroes().new Solution();
	 }
	 
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int length;
            if(nums == null || (length = nums.length) == 0 ) {
                return;
            }
            int j = 0;
            for ( int i = 0; i < length; i++) {
                if (nums[i] != 0){
                    if (i > j) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
