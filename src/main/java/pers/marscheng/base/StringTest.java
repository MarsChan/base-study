package pers.marscheng.base;

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

        String str1 = "hello world";
        String str2 = "hello world";

        System.out.println(str1==str2);
    }
}
