package pers.marscheng.leetcode;

import java.util.Arrays;

/**
 * @version 1.0
 * @className IsAnagram
 * @description
 * @author: marscheng
 * @date: 2020-06-14 3:09 PM
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        char[] chara={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','q','r','s','t','u','v','w','x','y','z'};
        int[] count = new int[26];
        for(char c:s.toCharArray()){
            for(int i=0;i<chara.length;i++){
                if(chara[i]==c){
                    count[i]=++count[i];
                }
            }
        }

        for(char c:t.toCharArray()){
            for(int i=0;i<chara.length;i++){
                if(chara[i]==c){
                    count[i]=--count[i];
                }
            }
        }

        for(int a:count){
            if(a!=0){
                return false;
            }
       }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] s1= s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1,s2);

    }


    public static void main(String[] args) {
        System.out.println(isAnagram("a","b"));


    }
}
