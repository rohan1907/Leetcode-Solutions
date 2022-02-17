class ListNode{
    int key, value;
    ListNode next, prev;
    ListNode(int key,int value){
         this.next = null;
        this.prev = null;
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    private int count;
    private HashMap<Integer, ListNode> mp = new HashMap<>();
    ListNode head = null, least = null;
    public LRUCache(int capacity) {
        this.count = capacity;
    }
    
    public int get(int key) {
        //System.out.println(mp);
        if(!mp.containsKey(key))
            return -1;
        ListNode node = mp.get(key);
        if(node == head)
            return node.value;
        if(node == least){
            if(least.prev == null){
                head = least;
                return least.value;
            }
            else{
                least = least.prev;
                least.next = null;
                node.next = head;
                head.prev=node;
                head=node;
                return head.value;
            }
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        head.prev = node;
        head = node;
        head.prev=null;
        
        return head.value;
    }
    
    public void put(int key, int value) {
        if(head == null && count >0){
            ListNode node = new ListNode(key,value);
            head=node;
            least=node;
            mp.put(key, node);
            count--;
        }
        else if(mp.containsKey(key)){
            ListNode node = mp.get(key);
            node.value = value;
            get(key);
            return;
        }
        
        else if(count <=0){
            ListNode lst = least;
            if(lst == head){
                ListNode node = new ListNode(key,value);
                mp.remove(lst.key);
                mp.put(key,node);
                head = least = node;
                return;
                
            }
            mp.remove(lst.key);
            least = least.prev;
            least.next = null;
            lst.prev=null;
            ListNode node = new ListNode(key,value);
            node.next = head;
            head.prev = node;
            head = node;
            mp.put(key,node);
            
        }
        
        else{
            ListNode node = new ListNode(key,value);
            node.next = head;
            head.prev = node;
            head = node;
            mp.put(key,node);
            count--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */