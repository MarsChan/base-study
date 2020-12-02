package pers.marscheng.leetcode.cache;

import java.util.HashMap;

/**
 * @version 1.0
 * @className LRUCacheNode
 * @description 自己实现链表
 * @author: marscheng
 * @date: 2020-11-29 9:51 PM
 */
public class LRUCacheNode {
    private HashMap<Integer, Node> keys = new HashMap<>();
    private DoubleList cache;
    private int capacity;


    public LRUCacheNode(int capacity) {
        this.capacity = capacity;
        cache = new DoubleList();
    }

    public int get(int key) {
        Node node = keys.get(key);
        if (node == null) {
            return -1;
        }
        makeRecently(key);
        return node.value;
    }

    public void put(int key, int val) {
        if (keys.containsKey(key)) {
            Node node = keys.get(key);
            node.value = val;
            cache.remove(node);
            cache.addLast(node);
            return;
        }
        if (cache.getSize() == capacity) {
            removeFirst();
        }
        Node node = new Node(key, val);
        keys.put(key, node);
        cache.addLast(node);
    }

    private void removeFirst() {
        int first = cache.removeFirst();
        keys.remove(first);

    }

    public void makeRecently(int key) {
        if (!keys.containsKey(key)) {
            return;
        }
        Node node = keys.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    //["LRUCache","put","put","put","put","get","get"]
    //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    public static void main(String[] args) {
        LRUCacheNode lRUCache = new LRUCacheNode(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));    // 返回 1
        System.out.println(lRUCache.get(2));    // 返回 -1
        lRUCache.put(2, 6);
        System.out.println(lRUCache.get(1));    // 返回 1

        lRUCache.put(1, 5); // 缓存是 {1=1, 2=2}
        lRUCache.put(1, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));    // 返回 -1

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

    class Node {
        public int key, value;
        public Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    class DoubleList {
        public Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = head;
            size = 0;
        }


        public void addLast(Node node) {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }

        public int removeFirst() {
            Node first = head.next;
            if (first == null) {
                return -1;
            }
            int key = first.key;
            remove(first);
            return key;
        }

        public void remove(Node node) {
            if (node == head) {
                return;
            }
            if (node == tail) {
                tail = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public int getSize() {
            return size;
        }
    }
}
