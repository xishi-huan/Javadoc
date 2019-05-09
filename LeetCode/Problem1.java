/*********************************************************
 * 描述：
 *      给定一个整数数组 nums 和一个目标值 target
 *      在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * 测试数据：
 *       ums = [0,7,11,0]  target = 0
 * 输出：
 *       0 3
 ********************************************************/
public class Problem1 {
    public static void main(String[] args){
        int[] num = new int[]{0,7,11,0};
        Solution s =new Solution();
        int[] res = s.twoSum(num,0);
        System.out.println(res[0]+ " " + res[1]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n;
        int[] result = new int[2];
        for(int i =0;i < nums.length;i++){
                n = target - nums[i];
                for (int j = nums.length - 1; j > i; j--) {
                    if (n == nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
        }
        return null;
    }
}