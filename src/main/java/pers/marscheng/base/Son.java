package pers.marscheng.base;

import sun.applet.Main;

/**
 * @program: base-study
 * @description: 儿子
 * @author: MarsCheng
 * @create: 2018-11-24 21:17
 **/
public class Son extends Father {
    public static void say() {
        System.out.println("I am son!");
    }

    @Override
    public void dosomething() {
        System.out.println("jumping....");
    }

    public static void main(String[] args) {
        //静态方法重写，父类的方法会被隐藏不生效
        Father.say();

        Father man = new Son();
        man.dosomething();

        man = new Father();
        man.dosomething();


    }

}
