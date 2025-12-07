
public class BST<E extends Comparable<E>> {
    
	// This is showing what one node in our tree is like
	// We store data and the left and right references to child nodes
	private static class Node<E> {
        E data;
        Node<E> left, right;
        Node(E data) { this.data = data; }
    }
	
	//  THis is our root node, which will be be set to null initially
    private Node<E> root;
    
    // If statement, when our tree is empty, new item becomes the root
    public boolean add(E item) {
        if (root == null) {
            root = new Node<>(item);
            return true;
        }
        return addRecursive(root, item);
    }
    
    // Compare item with node.data:
    // if it's duplicate, return false 
    // cmp < 0 means to go left
    // uses recursive to find the correct area to insert the node
    
    private boolean addRecursive(Node<E> node, E item) {
        int cmp = item.compareTo(node.data);
        if (cmp == 0) return false; // duplicate
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node<>(item);
                return true;
            }
            return addRecursive(node.left, item);
        } else {
            if (node.right == null) {
                node.right = new Node<>(item);
                return true;
            }
            return addRecursive(node.right, item);
        }
    }

    public E find(E target) {
        return findRecursive(root, target);
    }

    // searches by comparisons and moving left or right
    // if found, this will return a stored object, if not it returns null 
    private E findRecursive(Node<E> node, E target) {
        if (node == null) return null;
        int cmp = target.compareTo(node.data);
        if (cmp == 0) return node.data;
        return (cmp < 0) ? findRecursive(node.left, target) : findRecursive(node.right, target);
    }

    // my toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, 0);
        return sb.toString();
    }
    

    // prints tree sideways, right subtree first, then the current node, then the left subtree
    // indents the nodes based on depth 
    private void buildString(Node<E> node, StringBuilder sb, int depth) {
        if (node == null) return;
        buildString(node.right, sb, depth + 1);
        sb.append(" ".repeat(depth * 4)).append(node.data).append("\n");
        buildString(node.left, sb, depth + 1);
    }
}
