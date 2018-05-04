public class DoubleNode<T>{
    public T elem;
    public DoubleNode<T> right, left;

    public DoubleNode(T o){
        elem = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        elem = o;
        this.right = right;
        this.left = left;
    }

    public T getElem() {
        return elem;
    }

    public DoubleNode<T> getLeft() {
        return left;
    }

    public DoubleNode<T> getRight() {
        return right;
    }
}
