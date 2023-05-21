public class MyBinarySearchTree<K extends Comparable<K>, V>{
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val)
    {
        root = put(root, key, val);
    }
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
}
