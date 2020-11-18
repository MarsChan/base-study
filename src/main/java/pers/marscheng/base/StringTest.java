package pers.marscheng.base;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: base-study
 * @description: String测试
 * @author: MarsCheng
 * @create: 2018-12-27 20:17
 **/
public class StringTest {
    public static void main(String[] args) {
//        String sr1 =new StringBuffer("招商").append("金科").toString();
//        System.out.println(sr1.intern() == sr1);
//
//        String sr2 = new StringBuffer("ja").append("va").toString();
//        System.out.println(sr2.intern() == sr2);

        String str1 = "AAAAADDDD";
        String str2 = "hello world";

        System.out.println(getMostChar(""));
    }

    public static Character getMostChar(String s){
        if(StringUtils.isBlank(s)){
            return null;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> count = new HashMap<>();
        for (char aChar : chars) {
            if(!count.containsKey(aChar)){
                Integer num = 0;
                count.put(aChar, num);
            }else{
                Integer num = count.get(aChar)+1;
                count.put(aChar, num);
            }
        }

        Object[] characterSet = count.keySet().toArray();
        Character returnChar = (Character) characterSet[0];
        for(int i=0;i<characterSet.length-1;i++){
            if(count.get(characterSet[i])>count.get(characterSet[i+1])){
                returnChar= (Character) characterSet[i];
            }else{
                returnChar= (Character) characterSet[i+1];
            }
        }

        return returnChar;

    }



}
