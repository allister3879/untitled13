import java.util.*;

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
        if(isEmpty()){
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
            return null;
        }
    }
    public void delete(K key) {
        root = delete(root, key);
    }
    public int size() {
        return size(root);
    }
    public Iterable<Map.Entry<K, V>> iterator() {
        List<Map.Entry<K, V>>  entries = new ArrayList<>();
        inOrder(root, entries);
        return entries;
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
        Node temp; // create a temporary node to store the found node
        if(key.equals(current.key)){
            temp = current; // assign the current node to the temporary node
        }else {
            if(key.compareTo(current.key)<0){
                return get(key, current.left); // Recursively search in the left subtree
            }else {
                return get(key, current.right); // Recursively search in the right subtree
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
    private int size(Node node) {
        if (node == null) { // if the tree is empty, the size is 0
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right); // recursively calculate the size of the left and right subtree

        return leftSize + rightSize + 1; //sum of sizes of left subtree, right subtree and the current node
    }
    private void inOrder(Node current, List<Map.Entry<K, V>> entries) {
        if (current == null) {
            return;
        }

        inOrder(current.left, entries);  // traverse the left subtree
        entries.add(new AbstractMap.SimpleEntry<>(current.key, current.value));   // visit the current node
        inOrder(current.right, entries);  // traverse the right subtree
    }

    private Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node; // return the smallest node
    }

    public boolean isEmpty(){
        return root==null;  // check if root empty
    }
}
