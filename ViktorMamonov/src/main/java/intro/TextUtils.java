package intro;

import java.util.Arrays;

public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param  text
     * @return sorted by natural order array of unique words
     * */
    public static String[] getUniqueSortedWords(String text) {
//        TODO find mistake and correct it, so the method works correctly
        String[] words = getWords(text);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }
    /**
     * @param text
     * @return array with words, get from receive text
     *          if received argument is null
     *          or text length is zero
     *          return array with zero length
     * */
    public static String[] getWords(String text) {

//        TODO write your code here
        if (text == null || text.length() == 0) {
            return new String[0];
        }
        return text.split("; ", 0);
    }
    /**
     * @param words array with words
     * @return  array with unique words
     * */
    public static String[] getUniqueWords(String[] words) {

//        TODO write your code here
        String[] newWords = new String[words.length];

        int counter = copyWords(words, newWords);
        String[] finalArray = new String[counter];
        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = newWords[i];
        }
        return finalArray;
    }

    public static int copyWords(String[] src, String[] dst) {
        int counter = 0;
        for (int i = 0; i < src.length; i++) {
            if (!containWord(dst, src[i])) {
                dst[counter] = src[i];
                counter++;
            }
        }
        return counter;
    }

    public static boolean containWord(String[] array, String str) {
        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param  uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     * */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here
        Arrays.sort(uniqueWords);
        return uniqueWords;
    }
}