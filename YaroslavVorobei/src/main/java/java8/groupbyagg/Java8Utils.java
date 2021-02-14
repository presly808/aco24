package java8.groupbyagg;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by serhii on 04.02.18.
 */
public class Java8Utils {

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
         return list.stream().sorted((user2, user1) -> Double.compare(user1.money, user2.money))
                 .limit(limit).collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        return  list.stream().collect(Collectors.groupingBy(user -> user.department));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list, int limit){
        return list.stream().collect(Collectors
                .groupingBy(user -> user.department, Collectors
                        .summingDouble(user -> user.money)));
    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        return list.stream().collect(Collectors
                .groupingBy(user -> user.department.city, Collectors.toList()));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        Optional<Double> reduce = list.stream().map(user -> user.money).reduce((aDouble, aDouble2) -> aDouble + aDouble2);
        return reduce.get().doubleValue();
    }

    public static Double maxSalariesViaCollector(List<User> list){
        Optional<Double> collect = list.stream().map(user -> user.money).collect(Collectors.maxBy((o1, o2) -> o1.compareTo(o2)));
        return collect.get().doubleValue();
    }

}
