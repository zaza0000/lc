class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    // least recently used node
    ListNode head;
    // most recently used node
    ListNode tail;
    
    class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;
        ListNode(int _key, int _val) {
            key = _key;
            val = _val;
            pre = null;
            next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        System.out.println("get " + key);
        ListNode node = map.get(key);
        if (node == null) {
            System.out.println("not found");
            return -1;
        }
        else {
            toTail(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        System.out.println("put " + key);
        
        ListNode node;
        if (map.isEmpty()) {
            node = new ListNode(key, value);
            head = node;
            tail = node;
            map.put(key, node);
            return;
        }
        else {
            if (map.containsKey(key)) {
                node = map.get(key);
                node.val = value;
                toTail(node);
            }
            else {
                node = new ListNode(key, value);
                if (map.size() == capacity) {
                    map.remove(head.key);
                    if (capacity == 1) {
                        head = node;
                        tail = node;
                        map.put(key, node);
                        return;
                    }
                    head = head.next;
                    head.pre = null;
                }
                // put the node to the tail of the list
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
                map.put(key, node);
            }
            
        }
    }
    
    private void toTail(ListNode node) {
        if (tail == node) {
            return;
        }
        
        ListNode temp = node.next;
        temp.pre = node.pre;
        if (head == node) {
            head = temp;
        }
        else {
            temp = node.pre;
            temp.next = node.next;
        }
        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = node;
    }

    /**
     * Result
     * Runtime: faster than 7.27%
     * Memory: less than 5.17%
     */
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */