package pers.marscheng.algorithm.list;

import java.util.ArrayList;

/**
 * 栈算法题复习
 *
 * @author: marscheng
 * @date: 2018-04-25 1:24 PM
 */
public class Stack {
    /**
     * 题目描述:用I表示入栈,O表示出栈,给算法判断给定的操作序列是否是合法序列(初态和终态都为空)
     *
     * @param list
     * @return
     */
    private static boolean check(char[] list) {
        int i = 0, o = 0,j=0;
        while(j<list.length) {
            switch (list[j]) {
                case 'I':
                    i++;
                    break;
                case 'O':
                    o++;
                    if (i < o) {
                        return false;
                    }
            }
            j++;
        }
        if (i != o){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) {
        //test for check
        char[] list = {'I','I','I','O','O'};
        char[] chars = new char[3];
        ArrayList<Character> list1 = new ArrayList<Character>();
        System.out.println(4%3);
        System.out.println(check(list));
    }
}
