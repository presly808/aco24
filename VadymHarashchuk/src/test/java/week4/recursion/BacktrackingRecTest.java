package week4.recursion;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BacktrackingRecTest {


    @Test
    public void canFindSum() {
        int[] mas = {1, 5, 10, 20, 9, 7};
        assertTrue(BacktrackingRec.canFindSum(mas, 14));
        assertTrue(BacktrackingRec.canFindSum(mas, 1));
        assertFalse(BacktrackingRec.canFindSum(new int[]{1, 0, 0}, 14));
        assertFalse(BacktrackingRec.canFindSum(mas, 2));


    }

    @Test
    public void findChainIfPossible() {
        int[] mas = {1, 5, 10, 20, 9, 7};
        assertArrayEquals(BacktrackingRec.findChainIfPossible(mas, 8), new int[]{1, 7});
        assertNotSame(BacktrackingRec.findChainIfPossible(mas, 8), new int[]{6, 7});

    }

    @Test
    public void allPossibleCombination() {
        int[] mas = {1, 5, 10, 20, 9, 7};
        Map<Integer, List<int[]>> map = BacktrackingRec.allPossibleCombination(mas, new int[]{14, 26, 0});

        int[] num14_1 = map.get(14).get(0);
        int[] num26_1 = map.get(26).get(0);
        int[] num26_2 = map.get(26).get(1);
        int[] num0 = map.get(0).get(0);

        assertArrayEquals(num14_1, new int[]{5, 9});
        assertArrayEquals(num26_1, new int[]{20, 5, 1});
        assertArrayEquals(num26_2, new int[]{10, 9, 7});
        assertArrayEquals(num0, new int[]{});


    }
}

