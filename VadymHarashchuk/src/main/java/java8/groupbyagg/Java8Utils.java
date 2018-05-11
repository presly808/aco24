package java8.groupbyagg;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit) {

        return list.stream()
                .sorted(Comparator.comparingDouble(User::getMoney).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list) {

        return list.stream()
                .collect(Collectors.groupingBy(User::getDepartment));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit) {


        return list.stream()
                .collect(Collectors.groupingBy(User::getDepartment, Collectors.summingDouble(User::getMoney)));

    }

    public static Map<String, List<User>> groupByCityName(List<User> list) {


        return list.stream()
                .collect(Collectors.groupingBy(user -> user.department.city));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list) {

        return list.stream()
                .mapToDouble(user -> user.money)
                .reduce(0, (sum, user) -> sum += user);
    }

    public static Double maxSalariesViaCollector(List<User> list) {

        return list.stream()
                .max(Comparator.comparingDouble(user -> user.money))
                .map(user -> user.money).get();
    }


}
