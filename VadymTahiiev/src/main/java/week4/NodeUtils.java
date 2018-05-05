package week4;

public interface NodeUtils<T> {


    void addToTail(Node<T> first, T val);

    Node<T> addToHead(Node<T> chain, T val);

    String toString(Node<T> chain);

    Node<T> createNode(T... mas);

    Node<T> createNodeR(T... mas);

    int count(Node<T> chain);

    Node<T> remove(Node<T> chain, T val);

    Object[] toArray(Node<T> chain);

    //reverse using loop
    Node<T> reverse(Node<T> curr);

    //reverse usin recursion
    Node<T> reverse(Node<T> curr, Node<T> next, Node<T> prev);


}