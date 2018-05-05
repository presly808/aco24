package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class Node<T> {

    public Node next;
    public T value;

    public Node() {
    }

    public  Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }

}
