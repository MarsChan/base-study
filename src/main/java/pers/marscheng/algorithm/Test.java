package pers.marscheng.algorithm;

import pers.marscheng.algorithm.list.DLinkList;

import java.util.Arrays;
import java.util.List;

/**
 * 测试
 *
 * @author: marscheng
 * @date: 2018-04-17 5:03 PM
 */
public class Test {
    public static void main(String[] args) {
        DLinkList<Integer> linkList = new DLinkList<Integer>();
        List<Integer> intList = Arrays.asList(2, 4, 3, 2,7,8,9);
        linkList.createList(intList, "tail");
        linkList.printList();

    }
}
