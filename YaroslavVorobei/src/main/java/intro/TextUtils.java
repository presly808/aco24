package intro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param text
     * @return sorted by natural order array of unique words
     */
    public static String[] getUniqueSortedWords(String text, String delimeter) {
        String[] words = getWords(text, delimeter);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }

    /**
     * @param text
     * @return array with words, get from receive text
     * if received argument is null
     * or text length is zero
     * return array with zero length
     */
    public static String[] getWords(String text, String delimeter) {
       /* if(text == null || text.length()==0){
            return null;
        }*/
        return text.split(delimeter);
    }

    /**
     * @param words array with words
     * @return array with unique words
     * /*
     *//*
  /*  public static String[] getUniqueWords(String[] words) {
        Set<String> set = new HashSet<String>(Arrays.asList(words));
        return set.toArray(new String[set.size()]);
    }*/
    public static String[] getUniqueWords(String[] words) {
        String[] tempArr = new String[words.length];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (!hasElement(tempArr, words[i])) {
                tempArr[j] = words[i];
                j++;
            }
        }
        String[] uniqWords = Arrays.copyOf(tempArr, j);
        return uniqWords;
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {
        Arrays.sort(uniqueWords);
        return uniqueWords;
    }


    private static boolean hasElement(String[] words, String element) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && words[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
