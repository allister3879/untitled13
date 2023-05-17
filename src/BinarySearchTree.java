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
        if(isEmpty()){  //if the tree is empty we create a root node
            root = new Node(key, value);
        }else{
            put(key, value, root);
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
    public boolean isEmpty(){
        return root==null;  // check if root empty
    }
}
