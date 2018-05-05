package week4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        if (first == null){
            first.next = new Node(null, val);
        } else {
            addToTail(first.next,val);
        }

        new ArrayList<>().replaceAll();
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return new Node(chain,val);
    }

    @Override
    public String toString(Node chain) {
        String result = "";

        while (chain!=null){
            result += chain.value+"";
            chain = chain.next;
        }
        return result;
    }

    @Override
    public Node createNode(Object... mas) {
        //return null;
        if (mas.length == 0) return null;
        Node node = new Node(createNodeR(Arrays.copyOfRange(mas,1,mas.length)),mas[0]);
        return node;
    }

    @Override
    public Node createNodeR(Object... mas) {
        if (mas.length == 0) return null;
        Node node = new Node(createNodeR(Arrays.copyOfRange(mas,1,mas.length)),mas[0]);
        return node;
    }

    @Override
    public int count(Node chain) {
        if (chain.next == null){
            return 1;
        }
        else return 1 + count(chain.next);
    }

    @Override
    public Node remove(Node chain, Object val) {
        if (chain.value.equals(val)){
            Node secondNode = chain.next;
            Node result = new Node(secondNode, chain.value);
            chain = chain.next;
            return result;
        } else if (chain.next == null) {
            return null;
        } else if (chain.next.value.equals(val)){
            Node nextNextNode = chain.next.next;
            Node secondElement = chain.next;
            chain.next = nextNextNode;
           return secondElement;
        } else {
            return remove(chain.next,val);
        }
    }

    @Override
    public Object[] toArray(Node chain) {
        if (chain.value == null) {
            return new Object[0];
        }
        int sizeValue = 0;
        while (chain != null) {
            sizeValue += 1;
            chain = chain.next;
        }

        Object[] objects = new Object[sizeValue];
        for (int i = 0; i < sizeValue; i++) {
            if (chain != null){
                objects[i] = chain.value;
                chain = chain.next;
            }
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
