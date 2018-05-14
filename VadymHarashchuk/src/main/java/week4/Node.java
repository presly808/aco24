package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class Node<T> {

    public Node<T> next;
    public Object value;

    public Node() {
    }

    public Node(Node<T> next, Object value) {
        this.next = next;
        this.value = value;
    }

}
