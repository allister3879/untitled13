The BinarySearchTree class is a generic class that accepts two type parameters: K for the key and V for the value associated with each key.
The Node class is a private inner class that represents a node in the binary search tree. Each node contains a key-value pair, as well as references to its left and right child nodes.
The class has several methods for various operations on the BST:

put(K key, V value) method is used to insert a key-value pair into the BST. It calls the private put() method to recursively traverse the tree and find the appropriate position to insert the new node.

get(K key) method is used to retrieve the value associated with a given key. It calls the private get() method to recursively search for the key in the tree.

delete(K key) method is used to remove a node with the given key from the BST. It calls the private delete() method to handle different cases of deletion, such as when the node to be deleted has no children, one child, or two children.

size() method calculates and returns the total number of nodes in the BST by invoking the private size() method recursively on each subtree.

iterator() method returns an iterable object that allows iterating over the key-value pairs in the BST. It uses in-order traversal by calling the private inOrder() method, which recursively visits the nodes in ascending order of keys and adds them to a list of Map.Entry<K, V> objects.

The private helper methods, such as put(), get(), delete(), size(), inOrder(), and findSuccessor(), handle the internal logic for their respective operations using recursion and other techniques.
The isEmpty() method checks if the BST is empty by checking if the root node is null.
