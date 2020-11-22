package pers.marscheng.leetcode.dynamic;

/**
 * @version 1.0
 * @className Fibonacci
 * @description 斐波那契数列数列
 * @author: marscheng
 * @date: 2020-11-22 5:11 PM
 */

import java.util.HashMap;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 给定 N，计算 F(N)。

 示例 1：

 输入：2
 输出：1
 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 示例 2：

 输入：3
 输出：2
 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 示例 3：

 输入：4
 输出：3
 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fibonacci-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(4));

    }


    /**
     * 递归实现
     */
    public static int fib(int N) {
        if(N==0) {
            return 0;
        } else if(N==1||N==2) {
            return 1;
        }else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    /**
     * 递归实现 --加备忘录
     */
    public static int fib2(int N) {
        if(N<1) {
            return 0;
        }

        HashMap<Integer,Integer> memo = new HashMap<>();

        return helper(N,memo);
    }

    public static int helper(int N,HashMap<Integer,Integer> memo) {
        if (N == 1 || N == 2) {
            return 1;
        }
        if (memo.get(N) != null) {
            return memo.get(N);
        }
        memo.put(N, helper(N - 1, memo) + helper(N - 2, memo));
        return memo.get(N);
    }

    /**
     * 自下而上解法
     * @param N
     * @return
     */
    public static int fib3(int N){
        if(N <1){
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int[] dp = new int[N+1];
        dp[1]=1;dp[2]=1;
        for(int i = 3;i<=N;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
    }

}


