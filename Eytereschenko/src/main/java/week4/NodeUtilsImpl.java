package week4;

import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl<T> implements NodeUtils<T> {

    @Override
    public void addToTail(Node<T> first, T val) {

        if (first.next == null) {
            first.next = new Node<T>(null, val);
        } else {
            addToTail(first.next, val);
        }

    }

    @Override
    public Node<T> addToHead(Node<T> chain, T val) {

        return new Node<T>(chain, val);

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
    public Node<T> createNode(T... mas) {

        Node<T> node = new Node<>(null, mas[mas.length - 1]);
        for (int i = mas.length - 2; i >= 0; i--) {
            node = addToHead(node, mas[i]);
        }

        return node;

    }

    @Override
    public Node<T> createNodeR(T... mas) {

        if(mas.length == 0) {
            return null;
        }else {
            T[] newMas = partArray(mas);
            return new Node<T>(createNode(newMas), mas[0]);
        }
    }

    private T[] partArray(T[] mas) {

        T[] newMas = (T[]) new Object[mas.length - 1];
        for (int i = 1; i < mas.length; i++) {
            newMas[i - 1] = mas[i];
        }
        return newMas;
    }

    @Override
    public int count(Node<T> chain) {


        if (chain.next == null) {
            return 1;
        } else {
            return 1 + count(chain.next);
        }

    }

    @Override
    public Node<T> remove(Node<T> chain, T val) {


        Node<T> nodeTmp = chain;

        if(chain.value.equals(val)){
            chain = chain.next;
            return nodeTmp;
        } else if(chain.next.value.equals(val)){
            Node<T> result = chain.next;
            chain.next = chain.next.next;
            return result;
        } else {
            return remove(chain.next, val);
        }



    }

    @Override
    public T[] toArray(Node<T> chain) {

        int size = count(chain);
        T[] result = (T[]) new Object[size];
        int i = 0;

        while (chain.next != null){
            result[i++] = chain.value;

            chain = chain.next;
        }

        return result;
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
