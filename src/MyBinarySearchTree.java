import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<K extends Comparable<K>, V>{
    private Node root;

    /**
     * Represents a node in the binary search tree.
     */
    private class Node {
        private K key;
        private V val;
        private Node left, right;

        /**
         * Creates a new instance of the Node class.
         */
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Inserts a key-value pair into the binary search tree.
     */
    public void put(K key, V val)
    {
        root = put(root, key, val);
    }

    /**
     * Private helper method to recursively insert a key-value pair into the binary search tree.
     */
    private Node put(Node node, K key, V val)
    {
        if(node == null){
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return get(node.left, key);
        }
        else if (cmp > 0){
            return get(node.right, key);
        }
        return node;
    }

    /**
     * Retrieves the value associated with the specified key.
     */
    public V get(K key){
        Node node = get(root, key);
        return node != null ? node.val : null;
    }

    /**
     * Private helper method to recursively search for a node with the specified key.
     */
    private Node get(Node node, K key) {
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return get(node.left, key);
        }
        else if (cmp > 0){
            return get(node.right, key);
        }
        return node;
    }

    /**
     * Finds the minimum key in the binary search tree.
     */
    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Deletes the node with the specified key from the binary search tree.
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    /**
     * Private helper method to recursively delete the node with the specified key from the binary search tree.
     */
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = delete(node.left, key);
        }
        else if (cmp > 0) {
            node.right = delete(node.right, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                Node minRightNode = findMin(node.right);
                node.key = minRightNode.key;
                node.val = minRightNode.val;
                node.right = delete(node.right, minRightNode.key);
            }
        }
        return node;
    }

    /**
     * Returns an iterator that iterates over the keys in ascending order.
     */    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }

    /**
     * Private helper method to perform inorder traversal of the binary search tree.
     * Collects the keys in ascending order into the specified list.
     */
    private void inorderTraversal(Node node, List<K> keys) {
        if (node == null)
            return;
        inorderTraversal(node.left, keys);
        keys.add(node.key);
        inorderTraversal(node.right, keys);
    }

    /**
     * Returns the number of nodes in the binary search tree.
     */
    public int size() {
        return size(root);
    }

    /**
     * Private helper method to recursively calculate the number of nodes in the binary search tree.
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }
}
