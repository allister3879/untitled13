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
    public V get(K key) {
        Node node = get(key, root);
        if (node != null) {
            return node.value;
        } else {
            return null; // Key not found in the BST
        }
    }
    public void delete(K key) {
        root = delete(root, key);
    }


    private Node put (K key, V value, Node current){
        if(key.compareTo(current.key) < 0){  //if key less than current key
            if(current.left == null) {
                current.left = new Node(key, value);// recurse to the left node until reach leaf node
            }else {
                current.left = put(key, value, current.left);
            }
        } else if (key.compareTo(current.key) > 0) { //if key greater than current key
            if(current.right == null) {
                current.right = new Node(key, value);  // recurse to the right node until reach leaf node
            }else {
                current.right = put(key, value, current.right);
            }
        }
        return current;
    }
    private Node get(K key, Node current) {
        Node temp;
        if(key.equals(current.key)){
            temp = current;
        }else {
            if(key.compareTo(current.key)<0){
                return get(key, current.left);
            }else {
                return get(key, current.right);
            }
        }
        return temp;
    }
    private Node delete(Node node, K key) {
        if (node == null) {
            return null; // Key not found in the BST
        }

        if (key.compareTo(node.key) < 0) {
            // If the key is less than the current node's key, delete from the left subtree
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            // If the key is greater than the current node's key, delete from the right subtree
            node.right = delete(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null; // Node has no children
            } else if (node.left == null) {
                return node.right; // Node has one right child
            } else if (node.right == null) {
                return node.left; // Node has one left child
            }else {
                // Node has two children
                Node successor = findSuccessor(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = delete(node.right, successor.key);
            }
        }
        return node;
    }

    private Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean isEmpty(){
        return root==null;  // check if root empty
    }
}
