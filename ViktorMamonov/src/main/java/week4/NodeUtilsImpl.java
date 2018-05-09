package week4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {

        if(first.next == null) {
            first.next = new Node(null, val);
        } else {
            addToTail(first.next, val);
        }

    }

    @Override
    public Node addToHead(Node chain, Object val) {
        new Node(chain, val);
        if (chain.next == null) {
            chain.next = new Node(null, val);
        }
        return chain.next;
    }

    @Override
    public String toString(Node chain) {
        StringBuilder str = new StringBuilder();
        str = str.append(chain.value);
        Node node = chain;
        if (node.next != null) {
            str.append(toString(node.next));

        }
        String completeString = str.toString().substring(0);

        return completeString;
    }

    @Override
    public Node createNode(Object... mas) {
        Node first = new Node(null, mas[0]);
        Node head = first;

        for (int i = 1; i < mas.length; i++) {
            first.next = new Node(null, mas[i]);
            first = first.next;
        }


        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {
        if (mas.length == 0)return null;

        return new Node(createNodeR(Arrays.copyOfRange(mas, 1, mas.length)), mas[0]);
    }

    @Override
    public int count(Node chain) {
         //new Node(chain.next,null);
        int counter = 0;
        Node node = chain;
        while (node != null) {
            counter++;
            node = node.next;

        }
        return counter;
    }

    @Override
    public Node remove(Node chain, Object val) {
        if(chain.next == null) {
            return null;

        } else if(chain.next.value.equals(val)){
            Node ret = chain.next;
            chain.next = ret.next;
            return ret;
        }
        return remove(chain, val);
    }

    @Override
    public Object[] toArray(Node chain) {
        Object[] objects = new Object[count(chain)];
        Node node = chain;
        int index = 0;
        while (node != null){
            objects[index++] = node.value;
            node = node.next;
        }

        return objects;
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

        if(curr == null){
            return prev;
        }

        next = curr.next;
        curr.next = prev;

        return reverse(next, next, curr);
    }
}
