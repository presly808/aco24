package week4.recursion;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by serhii on 03.02.18.
 */
public class BacktrackingRec {

    // [1,5,10,20,9,7] , 14-> true
    public static boolean canFindSum(int[] mas, int target) {

        if (target == 0) {
            return true;
        }
        if (mas.length == 0) {
            return false;
        }

        int a = target - mas[0];
        mas = Arrays.copyOfRange(mas, 1, mas.length);

        boolean rec1 = canFindSum(mas, a);
        boolean rec2 = canFindSum(mas, target);

        return rec1 || rec2;
    }

    // [1,5,10,20,9,7] , 13 -> [1,5,7]
    public static int[] findChainIfPossible(int[] mas, int target) {
        return findChainIfPossible(mas, new int[0], target);
    }

    private static int[] findChainIfPossible(int[] mas, int[] buff, int target) {
        if (mas.length == 0) {
            return target == 0 ? buff : new int[]{};
        }

        int[] arr = Arrays.copyOfRange(mas, 1, mas.length);

        int[] a1 = findChainIfPossible(arr, buff, target);
        int[] a2 = findChainIfPossible(arr, addAndRet(buff, mas[0]), target - mas[0]);

        return a1.length != 0 ? a1 : a2;
    }

    private static int[] addAndRet(int[] buff, int el) {
        int[] newArr = Arrays.copyOf(buff, buff.length + 1);
        newArr[newArr.length - 1] = el;
        return newArr;
    }

    // more complex solution based on above method
    public static Map<Integer, List<int[]>> allPossibleCombination(int[] income, int[] targets) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (Integer target : targets) {
            List<int[]> routes = new ArrayList<>();
            int[] chain1 = findChainIfPossible(income, target);
            routes.add(chain1);
            ArrayUtils.reverse(income);
            int[] chain2 = findChainIfPossible(income, target);

            if (chain1.length == chain2.length) {
                int countTheSame = 0;
                for (int i = 0, j = chain2.length - 1; i < chain1.length; i++, j--) {
                    if (chain1[i] == chain2[j]) countTheSame++;
                }
                if (countTheSame == chain1.length) {
                    map.put(target, routes);
                    continue;
                }
            }

            routes.add(chain2);
            map.put(target, routes);
        }

        return map;
    }

}
