package pers.marscheng.base;

import java.util.ArrayDeque;

/**
 * @program: xmlparse
 * @description: xml解析工具类
 * @author: Marscheng
 * @create: 2020-11-05 18:12
 **/

public class XmlParse {


    public static boolean checkFormat(String xml) {
        //去空格
        xml = xml.replaceAll(" ", "");
        char[] arrays = xml.toCharArray();
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder tag = new StringBuilder();
        boolean ifEnd = false;
        //遍历字符
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == '<') {
                if (arrays[i + 1] == '/') {
                    ifEnd = true;
                } else {
                    ifEnd = false;
                }
                tag.append(arrays[i]);
            } else if (arrays[i] == '/') { //为了方便比较，end tag和start转换为一致
                continue;
            } else if (arrays[i] == '>') {
                if ("<".equals(tag.toString()) || "</".equals(tag.toString())) {
                    return false;
                } else {
                    tag.append(arrays[i]);
                    if (ifEnd) { //如果是end tag
                        //如果栈头匹配，出栈
                        if (stack.getFirst().equals(tag.toString())) {
                            stack.pop();
                        }
                    } else {
                        //start tag入栈
                        stack.push(tag.toString());
                    }
                    //清空
                    tag.delete(0, tag.length());
                }
            } else {
                //不是tag不记录
                if (tag.length() != 0 && tag.indexOf("<") == 0) {
                    tag.append(arrays[i]);
                }
            }
        }
        //栈空，格式正确
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
