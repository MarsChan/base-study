package pers.marscheng.base.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @className AtomicTest
 * @description
 * @author: marscheng
 * @date: 2020-09-06 10:33 AM
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(10);
        integer.lazySet(100);
        System.out.println(integer.get());
    }
}
