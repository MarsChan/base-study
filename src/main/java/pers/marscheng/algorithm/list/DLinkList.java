package pers.marscheng.algorithm.list;

import java.util.List;

/**
 * 带头结点的双链表
 * 头结点只是标识,不存具体数据,可以存长度之类的
 *
 * @author: marscheng
 * @date: 2018-04-25 10:24 PM
 */
public class DLinkList<E> {
    /**
     * 节点内部类
     *
     * @param <E>
     */
    private static class Node<E> {
        /**
         * 数据
         */
        E data;
        /**
         * 下一个节点
         */
        Node<E> next;
        /**
         * 上一个节点
         */
        Node<E> prior;

        public Node(E data, Node<E> next, Node<E> prior) {
            this.data = data;
            this.next = next;
            this.prior = prior;
        }
    }

    /**
     * 头结点
     */
    private Node<E> head;

    /**
     * 尾节点
     */
    private Node<E> tail;

    //构造一个空链表
    public DLinkList() {
        head = new Node<E>(null, null, null);
        tail = null;
    }

    /**
     * 头插法插入节点
     *
     * @param data 数据
     */
    private void headInset(E data) {
        Node<E> node = new Node<E>(data, head.next, head);
        head.next = node;
    }

    /**
     * 尾插法插入节点
     *
     * @param data
     */
    private void tailInsert(E data) {
        //如果不是空表
        if (tail != null) {
            Node<E> node = new Node<E>(data, null, tail);
            tail.next = node;
            tail = node;
        } else { //空表
            Node<E> node = new Node<E>(data, null, head);
            head.next = node;
            tail = node;
        }

    }

    /**
     * 构建链表
     *
     * @param datas 数据
     * @param type  方式
     */
    public void createList(List<E> datas, String type) {
        //用头插法构建
        if (type.equals("head")) {
            for (E item : datas) {
                headInset(item);
            }
        } else { //用尾插法构建
            for (E item : datas) {
                tailInsert(item);
            }
        }
    }

    /**
     * 打印链表
     */
    public void printList() {
        Node<E> node = head.next;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }


}
