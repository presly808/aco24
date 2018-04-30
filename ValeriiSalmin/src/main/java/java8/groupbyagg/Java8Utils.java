package java8.groupbyagg;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        return list.stream()
                .sorted((user1, user2) -> Double.compare(user2.money, user1.money))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        return list.stream().collect(Collectors.groupingBy(o -> o.department));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit){
        return list.stream().collect(Collectors.groupingBy(o -> o.department, Collectors.summingDouble(user -> user.money)));
    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        return list.stream().collect(Collectors.groupingBy(o -> o.department.getCity()));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        return list.stream().map(user -> user.money).reduce((aDouble, aDouble2) -> aDouble + aDouble2).get();
    }

    public static Double maxSalariesViaCollector(List<User> list){
        return list.stream().collect(Collectors.maxBy(Comparator.comparing(o -> o.money))).get().money;
    }
}
