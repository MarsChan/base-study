package pers.marscheng.base;

import java.util.Set;
import java.util.TreeSet;

/**
 * 测试treeSet比较
 *
 * @author: marscheng
 * @date: 2019-01-06 3:48 PM
 */
public class TestTreeSetError {
    public static void main(String[] args){
        Set<TestTreeSetError> sets = new TreeSet<TestTreeSetError>();

        TestTreeSetError set1 = new TestTreeSetError();
        TestTreeSetError set2 = new TestTreeSetError();
        sets.add(set1);
        //sets.add(set2);

    }
}
