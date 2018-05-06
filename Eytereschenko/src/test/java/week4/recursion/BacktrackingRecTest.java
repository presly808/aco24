package week4.recursion;

import org.junit.Assert;
import org.junit.Test;

public class BacktrackingRecTest {

    public static int[] mas = {1,5,10,20,9,7};
    public static int target = 14;
    public static int target2 = 15;
    public static int target3 = 16;
    public static int target4 = 52;
    public static int targetNegative = 90;
    public static int targetNegative2 = 3;

    @Test
    public void canFindSum()throws Exception{

        Assert.assertTrue(BacktrackingRec.canFindSum(mas, target));
        Assert.assertTrue(BacktrackingRec.canFindSum(mas, target2));
        Assert.assertTrue(BacktrackingRec.canFindSum(mas, target4));

    }

    @Test
    public void canFindSumNegative()throws Exception{

        Assert.assertFalse(BacktrackingRec.canFindSum(mas, targetNegative));
        Assert.assertFalse(BacktrackingRec.canFindSum(mas, targetNegative2));

    }

    @Test
    public void findChainIfPossible()throws Exception{

        int[] result1 = BacktrackingRec.findChainIfPossible(mas, target4);
        int[] result2 = BacktrackingRec.findChainIfPossible(mas, target3);
        int[] result3 = BacktrackingRec.findChainIfPossible(mas, targetNegative);

        Assert.assertEquals(6, result1.length);
        Assert.assertEquals(2, result2.length);


    }

}
