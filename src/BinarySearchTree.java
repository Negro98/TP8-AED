import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable> {
    private DoubleNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(T elem) {
        root = new DoubleNode<T>(elem);
    }

    public BinarySearchTree(T elem, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        root = new DoubleNode<T>(elem, left.root, right.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        return root.elem;
    }

    public BinarySearchTree<T> getLeft() {
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.left;
        return t;
    }

    public BinarySearchTree<T> getRight() {
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.right;
        return t;
    }

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public boolean exists(T x) {
        return exists(root, x);
    }

    public T getMin() {
        return getMin(root).elem;
    }

    public T getMax() {
        return getMax(root).elem;
    }

    public T search(T x) {
        return search(root, x).elem;
    }

    public void insert(T x) {
        if(!exists(x)) {
            root = insert(root, x);
        }
    }

    public void eliminate(T x) {
        root = eliminate(root, x);
    }

    private boolean exists(DoubleNode<T> node, T x) {
        if (node == null) {
            return false;
        }

        if (x.compareTo(node.elem) == 0) {
            return true;
        } else if (x.compareTo(node.elem) < 0) {
            return exists(node.left, x);
        } else {
            return exists(node.right, x);
        }
    }

    private DoubleNode<T> getMin(DoubleNode<T> node) {
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    private DoubleNode<T> getMax(DoubleNode<T> node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    private DoubleNode<T> search(DoubleNode<T> node, T x) {
        if (x.compareTo(node.elem) == 0) {
            return node;
        } else if (x.compareTo(node.elem) < 0) {
            return search(node.left, x);
        } else {
            return search(node.right, x);
        }
    }

    private DoubleNode<T> insert(DoubleNode<T> node, T x) {
        if (node == null) {
            node = new DoubleNode<T>(x);
        } else if (x.compareTo(node.elem) < 0) {
            node.left = insert(node.left, x);
        } else {
            node.right = insert(node.right, x);
        }
        return node;
    }

    private DoubleNode<T> eliminate(DoubleNode<T> node, T x) {
        if (x.compareTo(node.elem) < 0) {
            node.left = eliminate(node.left, x);
        } else if (x.compareTo(node.elem) > 0) {
            node.right = eliminate(node.right, x);
        } else if (node.left != null && node.right != null) {
            node.elem = getMin(node.right).elem;
            node.right = eliminateMin(node.right);
        } else if (node.left != null) {
            node = node.left;
        } else {
            node = node.right;
        }
        return node;
    }

    private DoubleNode<T> eliminateMin(DoubleNode<T> node) {
        if (node.left != null) {
            node.left = eliminateMin(node.left);
        } else {
            node = node.right;
        }
        return node;
    }


    public void ChangeElem (T e){
        DoubleNode node= new DoubleNode(e);
        this.root=node;
    }
}


