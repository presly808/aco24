package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl<T> implements NodeUtils<T> {

    @Override
    public void addToTail(Node<T> first, T val) {
        Node<T> tail = first;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node<T>(null, val);

    }

    @Override
    public Node<T> addToHead(Node<T> chain, T val) {

        return new Node<T>(chain, val);
    }

    @Override
    public String toString(Node<T> chain) {

        Node<T> tail = chain;
        StringBuilder sb = new StringBuilder();

        while (tail != null) {
            sb.append(tail.value).append(" ");
            tail = tail.next;
        }

        return sb.toString();
    }

    @Override
    public Node<T> createNode(T... mas) {

        Node<T> head = null;
        Node<T> last = null;

        for (T m : mas) {
            if (head == null) {
                head = new Node<T>(null, m);
                last = head;
            } else {
                last.next = new Node<T>(null, m);
                last = last.next;
            }
        }
        return head;
    }

    @Override
    public Node<T> createNodeR(T... mas) {

        return mas.length == 0 ? null
        : new Node<T>(createNodeR(Arrays.copyOfRange(mas, 1, mas.length)), mas[0]);
    }

    @Override
    public int count(Node<T> chain) {
        int count = 0;
        Node<T> tail = chain;
        while (tail != null) {
            count++;
            tail = tail.next;
        }
        return count;
    }

    @Override
    public Node<T> remove(Node<T> chain, T val) {

        Node<T> result = chain;
        Node<T> previous = chain;

        while (!result.value.equals(val)) {
            previous = result;
            result = result.next;
        }
        previous.next = result.next;

        return result;
    }

    @Override
    public T[] toArray(Node<T> chain) {

        List<Node<T>> list = new ArrayList<>();
        Node<T> tail = chain;

        while (tail != null) {
            list.add(chain);
            tail = tail.next;
        }
        return (T[]) list.toArray();
    }

    // 1,2,3,4,5 -> 5,4,3,2,1
    @Override
    public Node<T> reverse(Node<T> curr) {

        Node<T> next = null;
        Node<T> prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Override
    public Node<T> reverse(Node<T> curr, Node<T> next, Node<T> prev) {

        if (curr == null) {
            return prev;
        }
        next = curr.next;
        curr.next = prev;

        return reverse(next, next, curr);
    }
}
