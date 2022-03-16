// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache
{
    int cap;
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.cap = cap;
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(map.containsKey(key)){
            Node temp = map.get(key);
            // as we are using it we have to move it to the head
            moveToHead(temp);
            
            return temp.value;
        }
        
        return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here
        if(map.containsKey(key)){
            // fetch Node for this key and just change its value
            Node temp = map.get(key);
            temp.value = value;
            
            moveToHead(temp);
        }
        else{
            Node temp = new Node(key, value);
            
            if(map.size() == cap){
                // removing tail from map
                map.remove(tail.key);
                // if cap == 1 || one element in list
                if(tail == head){
                    head = temp;
                    tail = temp;
                }
                else{
                    tail = tail.prev;
                    tail.next = null;
                    
                    temp.next = head;
                    head.prev = temp;
                    head = temp;
                }
            }
            else{
                // inserting first element
                if(head == null){
                    head = temp;
                    tail = temp;
                }
                else{
                    temp.next = head;
                    head.prev = temp;
                    temp.prev = null;
                    head = temp;
                }
            }
            map.put(key, temp);
        }
    }
    
    private void moveToHead(Node temp){
        // 2 or more element in list
        if(head != tail){
            // if temp != head
            if(temp.prev != null){
                temp.prev.next = temp.next;
                
                // if temp != tail
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }else{
                    tail = tail.prev;
                }
                
                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }
    }
}
