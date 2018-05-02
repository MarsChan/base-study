package pers.marscheng.algorithm.list;

import java.util.LinkedList;
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
    public class Node<E> {
        /**
         * 数据
         */
        public E data;
        /**
         * 下一个节点
         */
        public Node<E> next;
        /**
         * 上一个节点
         */
        public Node<E> prior;

        public Node(E data, Node<E> next, Node<E> prior) {
            this.data = data;
            this.next = next;
            this.prior = prior;
        }
    }

    /**
     * 头结点
     */
    public Node<E> head;

    /**
     * 尾节点
     */
    public Node<E> tail;

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
     * 根据特定位置找到节点
     * @param index 位置
     * @return
     */
    public Node<E> findByIndex(int index){
        Node<E> node = head;
        for(int i = 0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    /**
     * 根据值查找元素位置
     * @param data 元素值
     * @return 索引列表
     */
    public List<Integer> findByData(E data){
        List<Integer> indexs = new LinkedList<Integer>();
        Node<E> node = head;
        int index = 0;
        while((node = node.next) != null){
            index++;
            if(node.data.equals(data)){
                indexs.add(index);

            }
        }
        return indexs;
    }

    /**
     * 向特定位置插入数据
     * @param data 数据
     * @param index 位置
     */
    public void insertByIndex(E data, int index){
        Node<E> node = findByIndex(index);
        Node<E> newNode = new Node<E>(data,null,null);
        newNode.next = node;
        newNode.prior = node.prior;
        node.prior.next = newNode;
        node.prior= newNode;

    }

    /**
     * 删除指定链表节点
     * @param index
     */
    public void deleteByIndex(int index){
        Node<E> node = findByIndex(index);
        node.prior.next = node.next;
        node.next.prior = node.prior;
    }

    /**
     * 修改特定节点的数据
     * @param data 数据
     * @param index 位置
     */
    public void updateByIndex(E data,int index){
        Node<E> node = findByIndex(index);
        node.data = data;
    }

    /**
     * 将链表逆序
     * 因为加入了头结点,所以这块逆序要特别注意下,很可能不小心就会漏了头结点,
     * 而且头指针变成为指针也要注意next要为空,否则会形成循环链表
     */
    public void reverse(){
        //从头结点开始逆置
        Node<E> prev = head;
        head = head.next;
        Node<E> next = head.next;
        //头指针要作为尾指针,next指向空,否则会出现循环链表
        head.next = null;
        while(next != null){
            prev = head;
            head = next;
            next = next.next;
            head.next = prev;
            head.prior = null;
            prev.prior = head;

        }
        //补充头结点
        prev = head;
        head = new Node<E>(null,prev,null);
        prev.prior = head;
    }
    /**
     * 打印链表
     */
    public void printList() {
        Node<E> node = head.next;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println("\n=========我是分割线===========");
    }


}
