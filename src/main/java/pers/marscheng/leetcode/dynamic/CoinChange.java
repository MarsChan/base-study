package pers.marscheng.leetcode.dynamic;

/**
 * @version 1.0
 * @className CoinChange
 * @description 零钱兑换问题
 * @author: marscheng
 * @date: 2020-11-22 6:05 PM
 */

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 你可以认为每种硬币的数量是无限的。

  

 示例 1：

 输入：coins = [1, 2, 5], amount = 11
 输出：3
 解释：11 = 5 + 5 + 1
 示例 2：

 输入：coins = [2], amount = 3
 输出：-1
 示例 3：

 输入：coins = [1], amount = 0
 输出：0
 示例 4：

 输入：coins = [1], amount = 1
 输出：1
 示例 5：

 输入：coins = [1], amount = 2
 输出：2

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/coin-change
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins={2,5,10,1};
        int count = coinChange.coinChange(coins,27);
        System.out.println(count);

    }


    int[] memo;

    /**
     * 暴力解法,会超时
     * @param coins
     * @param amount
     * @return
     */
    public  int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        memo = new int[amount+1];

        return count(coins,amount,0);
    }

    private  int count(int[] coins, int amount,int count){
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0 ;
        }
        if(memo[amount]!=0){
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = count(coins,amount-coins[i],count+1);
            if(res>=0&&res<min){
                min = res+1;
            }
        }
        memo[amount] = min!=Integer.MAX_VALUE? min:-1;
        return memo[amount];
    }
}
