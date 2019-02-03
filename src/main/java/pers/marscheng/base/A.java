package pers.marscheng.base;

import pers.marscheng.exception.MyException;
import pers.marscheng.exception.NewMyException;

/**
 * @program: base-study
 * @description: 测试接口
 * @author: MarsCheng
 * @create: 2019-02-01 16:06
 **/
public interface A {
    void methodX() throws MyException, NewMyException;
}
