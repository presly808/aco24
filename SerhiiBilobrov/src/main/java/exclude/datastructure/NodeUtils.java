package exclude.datastructure;

import java.util.Arrays;

/**
 * Created by serhii on 05.05.18.
 */
public class NodeUtils {
    public static void main(String[] args) {
        Integer[] mas = {1,2,3,4,5,6,7};
        Node first = createNodeR(mas);
        System.out.println(asStr(first));
    }

    // 1,2,3,4,5,6 => 1 -> 2 -> 3 -> 4
    public static Node createNodeR(Object... mas) {

        if(mas.length == 0){
            return null;
        }

        return new Node(mas[0], createNodeR(Arrays.copyOfRange(mas, 1, mas.length)));
    }

    public static String asStr(Node node){
        if(node == null){
            return "";
        }

        return node.value + "->" + asStr(node.next);
    }

    private static class Node {
        public Object value;
        public Node next;

        public Node() {
        }

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
