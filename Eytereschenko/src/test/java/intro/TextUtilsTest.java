package intro;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 31.03.18.
 */
public class TextUtilsTest {


    @Test
    public void testGetWords1(){
        String[] expected = {"cab", "abc", "cab", "cab", "bac", "bac"};
        String[] actual = TextUtils.getWords("cab; abc; cab; cab; bac; bac");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetWords2(){
        String[] expected = {};
        String[] actual = TextUtils.getWords("");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetWords3(){
        String[] expected = {};
        String[] actual = TextUtils.getWords(null);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetUniqueWords(){
        String[] expected = {"cab", "abc", "bac"};
        String[] actual = {"cab", "abc", "cab", "cab", "bac", "bac"};
        actual = TextUtils.getUniqueWords(actual);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortWords(){
        String[] expected = {"abc", "bac", "cab"};
        String[] actual = {"cab", "abc", "bac"};
        actual = TextUtils.sortWords(actual);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetUniqueSortedWords1(){
        String[] expected = {"abc", "bac", "cab"};
        String[] actual = TextUtils.getUniqueSortedWords("cab; abc; cab; cab; bac; bac");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetUniqueSortedWords2(){
        String[] expected = {};
        String[] actual = TextUtils.getUniqueSortedWords(null);
        assertArrayEquals(expected, actual);
    }

}