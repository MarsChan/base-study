package pers.marscheng.algorithm;

import pers.marscheng.algorithm.list.DLinkList;

import java.util.Arrays;
import java.util.List;

/**
 * 测试方法
 *
 * @author: marscheng
 * @date: 2018-04-17 5:03 PM
 */
public class Test {
    public static void main(String[] args) {
        DLinkList<Integer> linkList = new DLinkList<Integer>();
        //初始化链表
        List<Integer> intList = Arrays.asList(2, 4, 3, 2, 7, 8, 9);
        //尾插法
        linkList.createList(intList, "tail");
        linkList.printList();
        //插入数据
        linkList.insertByIndex(8, 3);
        linkList.printList();
        //查找特定值的位置
        List<Integer> indexs = linkList.findByData(8);
        for(int i:indexs){
            System.out.print(i+",");
        }
        System.out.println("\n=========我是分割线===========");
        //查找特定位置的值
        DLinkList<Integer>.Node<Integer> node = linkList.findByIndex(3);
        System.out.println(node.data);
        System.out.println("=========我是分割线===========");
        //删除数据
        linkList.deleteByIndex(3);
        linkList.printList();
        //双链表逆置
        linkList.reverse();
        linkList.printList();




    }
}
