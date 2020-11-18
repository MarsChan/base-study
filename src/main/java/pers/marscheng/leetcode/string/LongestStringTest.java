package pers.marscheng.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-08-04 13:01
 **/

public class LongestStringTest {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> occ = new HashSet<>();
        int n =s.length();
        int rk = -1,ans = 0;
        for (int i=0;i<n;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }

            while(rk+1<n&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }

            ans = Math.max(ans, rk+1-i);

            if(rk+1>=n) break;
        }
        return ans;

    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring2("abcdefg"));

        System.out.println(1 << 30);

        System.out.println(1>>>30);
    }

}
