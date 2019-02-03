package pers.marscheng.base;

import pers.marscheng.base.impl.AImpl;
import pers.marscheng.exception.MyException;

/**
 * @program: base-study
 * @description: 测试接口调用
 * @author: MarsCheng
 * @create: 2019-02-01 16:24
 **/
public class ModuleUser {
    public void methodY(A a) throws MyException
    {
        a.methodX();
    }

    public static void main(String[] args){
        ModuleUser moduleUser = new ModuleUser();
        AImpl a = new AImpl();
        try {
            moduleUser.methodY(a);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
