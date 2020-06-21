package pers.marscheng.base.mainkey;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @version 1.0
 * @className TestDomain
 * @description
 * @author: marscheng
 * @date: 2020-06-21 2:27 PM
 */
public class TestDomain implements Serializable {
    private String a;
    private String b;

    private transient String c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public static void main(String[] args) {
        TestDomain domain = new TestDomain();
        domain.setA("A");
        domain.setB("B");
        domain.setC("C");
        System.out.println(JSON.toJSONString(domain));
    }
}
