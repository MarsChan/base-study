package pers.marscheng.base;

/**
 * @program: base-study
 * @description: 类初始化顺序测试
 * @author: MarsCheng
 * @create: 2019-01-20 16:22
 **/
public class InitClassTest {
    public static String str1 = "static";

    static{
        System.out.println("str1===="+str1+" in block");
        String st2 = "static block";
        System.out.println(st2);
    }

    protected String str3 = "instance";

    {
        System.out.println("str1===="+str3+" in block");
        String str4 = "instance block";
        System.out.println(str4);
    }

    public void print(){
        System.out.println("str1===="+str1+" in method");
    }

    public static void main(String args[]){
        InitClassTest test = new InitClassTest();
        System.out.println(test instanceof Object);
        test.print();

    }
}


