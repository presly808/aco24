package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class Node {

    public Node next;
    public Object value;

    public Node(Node next, Object value) {
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
