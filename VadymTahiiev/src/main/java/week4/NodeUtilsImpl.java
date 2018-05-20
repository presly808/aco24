package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl<T> implements NodeUtils<T> {

    @Override
    public void addToTail(Node<T> first, T val) {
        if(first.next == null) {
            first.next = new Node(null, val);
        } else {
            addToTail(first.next, val);
        }
    }

    @Override
    public Node<T> addToHead(Node<T> chain, T val) {
        Node node = new Node(chain, val);
        return node;
    }

    @Override
    public String toString(Node<T> chain) {
        if (chain.next == null) {
            return chain.value.toString();
        } else {
            return toString(chain.next) + chain.value.toString();
        }
    }

    @Override
    public Node createNode(T... mas) {
        Node node = new Node();
        for (int i = 0; i < mas.length; i++) {
            node.value = mas[i];
            node.next = node;
        }
        return node;
    }

    @Override
    public Node createNodeR(Object... mas) {
        return null;
    }

    @Override
    public int count(Node<T> chain) {
        if (chain == null) {
            return 0;
        }
        if (chain.next == null) {
            return 1;
        } else {
            return count(chain.next) + 1;
        }
    }

    @Override
    public Node<T> remove(Node<T> chain, T val) {
        if (chain.next.value == val) {
            Node<T> removedChain = chain.next;
            chain.next = chain.next.next;
            return removedChain;
        } else {
           return remove(chain.next, val);
        }
    }

    @Override
    public Object[] toArray(Node chain) {
        return new Object[0];
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

        if(curr == null){
            return prev;
        }

        next = curr.next;
        curr.next = prev;

        return reverse(next, next, curr);
    }
}
