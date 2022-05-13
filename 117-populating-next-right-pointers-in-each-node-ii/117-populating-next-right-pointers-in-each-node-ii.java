/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node connect(Node root) {
        recur(root, 0);
        return root;
    }
    private void recur(Node root, int level){
        if(root == null) return;
        if(!map.containsKey(level))map.put(level, null);
        root.next = map.get(level);
        map.put(level, root);
        recur(root.right, level+1);
        recur(root.left, level+1);
    }
}