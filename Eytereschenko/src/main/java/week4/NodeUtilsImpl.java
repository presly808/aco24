package week4;

import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {

        if (first.next == null) {
            first.next = new Node(null, val);
        } else {
            addToTail(first.next, val);
        }

    }

    @Override
    public Node addToHead(Node chain, Object val) {

        return new Node(chain, val);

    }

    @Override
    public String toString(Node chain) {

        StringBuilder sb = new StringBuilder();
        sb = sb.append(chain.value + "->");
        if (chain.next != null) {
            sb.append(toString(chain.next));
        }
        return sb.toString();

    }

    @Override
    public Node createNode(Object... mas) {

        Node node = new Node(null, mas[mas.length - 1]);
        for (int i = mas.length - 2; i >= 0; i--) {
            node = addToHead(node, mas[i]);
        }

        return node;

    }

    @Override
    public Node createNodeR(Object... mas) {

        if(mas.length == 0) {
            return null;
        }else {
            Object[] newMas = partArray(mas);
            return new Node(createNode(newMas), mas[0]);
        }
    }

    private Object[] partArray(Object[] mas) {

        Object[] newMas = new Object[mas.length - 1];
        for (int i = 1; i < mas.length; i++) {
            newMas[i - 1] = mas[i];
        }
        return newMas;
    }

    @Override
    public int count(Node chain) {


        if (chain.next == null) {
            return 1;
        } else {
            return 1 + count(chain.next);
        }

    }

    @Override
    public Node remove(Node chain, Object val) {


        Node nodeTmp = chain;

        if(chain.value.equals(val)){
            chain = chain.next;
            return nodeTmp;
        } else if(chain.next.value.equals(val)){
            Node result = chain.next;
            chain.next = chain.next.next;
            return result;
        } else {
            return remove(chain.next, val);
        }



    }

    @Override
    public Object[] toArray(Node chain) {

        int size = count(chain);
        Object[] result = new Object[size];
        int i = 0;

        while (chain.next != null){
            result[i++] = chain.value;

            chain = chain.next;
        }

        return result;
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
