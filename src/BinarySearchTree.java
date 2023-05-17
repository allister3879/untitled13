public class BinarySearchTree <K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    // methods
    public void put(K key, V value){
        if(isEmpty()){  //if the tree is empty create a root node
            root = new Node(key, value);
        }else{
            put(key, value, root);
        }
    }
    public V get(K key){
        if(isEmpty()){ // if tree is empty return null
            return null;
        }else {
            Node node = get(key, root);
            return node.value;
        }
    }
    private Node put (K key, V value, Node current){
        if(key.compareTo(current.key) < 0){  //if key less than current key
            if(current.left == null) {
                current = new Node(key, value); // recurse to the left node until reach leaf node
            }else {
                current.left = put(key, value, current.left);
            }
        } else if (key.compareTo(current.key) > 0) { //if key greater than current key
            if(current.right == null) {
                current = new Node(key, value);  // recurse to the right node until reach leaf node
            }else {
                current.right = put(key, value, current.right);
            }
        }
        return current;
    }
    private Node get(K key,Node current){
        Node temp = new Node(null,null); //create a temp node to store the found node
        if(key.equals(current.key)){
            temp = current; // assign the current node to the temp node
        }else {
            if(key.compareTo(current.key)<0)
                return get(key, current.left); // recursively search in the left subtree and return the result
            if(key.compareTo(current.key)>0)
                return get(key, current.right); //recursively search in the right subtree and return the result
        }
        return temp;  // return temp node
    }
    public boolean isEmpty(){
        return root==null;  // check if root empty
    }
}
