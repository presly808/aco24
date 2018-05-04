package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        Node tail = first;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(null, val);

    }

    @Override
    public Node addToHead(Node chain, Object val) {

        return new Node(chain, val);
    }

    @Override
    public String toString(Node chain) {

        Node tail = chain;
        StringBuilder sb = new StringBuilder();

        while (tail != null) {
            sb.append(tail.value + " ");
            tail = tail.next;
        }

        return sb.toString();
    }

    @Override
    public Node createNode(Object... mas) {

        Node head = null;
        Node last = null;

        for (Object m : mas) {
            if (head == null) {
                head = new Node(null, m);
                last = head;
            } else {
                last.next = new Node(null, m);
                last = last.next;
            }
        }
        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {


        return null;
    }

    @Override
    public int count(Node chain) {
        int count = 0;
        Node tail = chain;
        while (tail != null) {
            count++;
            tail = tail.next;
        }
        return count;
    }

    @Override
    public Node remove(Node chain, Object val) {

        Node result = chain;
        Node previous = chain;

        while (!result.value.equals(val)) {
            previous = result;
            result = result.next;
        }
        previous.next = result.next;

        return result;
    }

    @Override
    public Object[] toArray(Node chain) {

        List<Node> list = new ArrayList<>();
        Node tail = chain;

        while (tail != null) {
            list.add(chain);
            tail = tail.next;
        }
        return list.toArray();
    }

    // 1,2,3,4,5 -> 5,4,3,2,1
    @Override
    public Node reverse(Node curr) {

        Node next = null;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Override
    public Node reverse(Node curr, Node next, Node prev) {

        if (curr == null) {
            return prev;
        }
        next = curr.next;
        curr.next = prev;

        return reverse(next, next, curr);
    }
}
