package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class lc146 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class LRUCache {

        private Map<Integer, doubleLinkedNode> hash;
        private int capacity;
        private int num;
        private doubleLinkedNode head;
        private doubleLinkedNode tail;

        class doubleLinkedNode {
            public int key;
            public int val;
            public doubleLinkedNode next;
            public doubleLinkedNode pre;

            doubleLinkedNode(){}

            doubleLinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            hash = new HashMap();
            num = 0;
            head = new doubleLinkedNode();
            tail = new doubleLinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (hash.containsKey(key)) {
                doubleLinkedNode node = hash.get(key);
                add(remove(node));
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            doubleLinkedNode newNode;
            if (hash.containsKey(key)) {
                newNode = hash.get(key);
                newNode.val = value;
                add(remove(newNode));
            } else {
                newNode = new doubleLinkedNode(key, value);
                if (num == capacity) {
                    hash.remove(remove(tail.pre).key);
                    add(newNode);
                    hash.put(key, newNode);
                } else {
                    num++;
                    add(newNode);
                    hash.put(key, newNode);
                }
            }
        }

        private void add(doubleLinkedNode node) {
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            node.pre = head;
        }

        private doubleLinkedNode remove(doubleLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node;
        }
    }
}

//class LRUCache extends LinkedHashMap<Integer, Integer>{
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}
//
///**
// * Your LRUCache object will be instantiated and called as such:
// * LRUCache obj = new LRUCache(capacity);
// * int param_1 = obj.get(key);
// * obj.put(key,value);
// */
