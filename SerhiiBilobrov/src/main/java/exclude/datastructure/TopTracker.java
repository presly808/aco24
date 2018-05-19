package exclude.datastructure;

import com.google.common.collect.*;

import java.util.*;
import java.util.stream.Collectors;

public class TopTracker {

    private final int topValuesCount;
    private final PriorityQueue<Integer> queue;

    public TopTracker(int topValuesCount) {
        this.topValuesCount = topValuesCount;
        this.queue = new PriorityQueue<>((el1, el2) -> el2.compareTo(el1));
    }

    public List<Integer> getTop() {

        return queue.stream().limit(topValuesCount).collect(Collectors.toList());
    }

    public void track(Integer element) {
        queue.add(element);
    }

    public static void main(String[] args) {
        TopTracker topTracker = new TopTracker(3);
        topTracker.track(54);
        topTracker.track(2);
        topTracker.track(-6);
        topTracker.track(10);
        topTracker.track(3);

        System.out.println("Limit");
        topTracker.getTop().stream().forEach(System.out::println);


        Iterator<Integer> iterator = topTracker.queue.iterator();
        System.out.println("Iter");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //
        System.out.println("toArray");
        Arrays.stream(topTracker.queue.toArray()).limit(3).forEach(System.out::println);


        System.out.println("Poll");
        System.out.println(topTracker.queue.poll());
        System.out.println(topTracker.queue.poll());
        System.out.println(topTracker.queue.poll());



    }
}