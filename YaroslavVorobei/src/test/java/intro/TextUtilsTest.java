package intro;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextUtilsTest {
    @Test
    public void getUniqueSortedWords() throws Exception {
        String str = "oop,lsd,cpa,java";
        String[] AR = TextUtils.getUniqueSortedWords(str, ",");
        String[] ER = {"cpa", "java", "lsd", "oop"};
        Assert.assertArrayEquals(ER, AR);
    }

    @Test
    public void getWords() throws Exception {
        String str = "oop,lsd,cpa";
        String[] ER = {"oop", "lsd", "cpa"};
        String[] AR = TextUtils.getWords(str, ",");

        Assert.assertArrayEquals(ER, AR);
    }

    @Test
    public void getUniqueWords() throws Exception {
        String[] array = {"oop", "cpa", "oop"};
        String[] AR = TextUtils.getUniqueWords(array);
        String[] ER = {"oop", "cpa"};
        Assert.assertArrayEquals(ER, AR);
    }

    @Test
    public void sortWords() throws Exception {
        String[] array = {"cpa", "apple", "java"};
        String[] AR = TextUtils.sortWords(array);
        String[] ER = {"apple", "cpa", "java"};
        Assert.assertArrayEquals(ER, AR);
    }

}