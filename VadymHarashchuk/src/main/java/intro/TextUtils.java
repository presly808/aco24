package intro;

import java.util.Arrays;

public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param text
     * @return sorted by natural order array of unique words
     */
    public static String[] getUniqueSortedWords(String text) {
//        TODO find mistake and correct it, so the method works correctly
        String[] words = getWords(text);
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
    public static String[] getWords(String text) {

//        TODO write your code here
        if (text == null || text.length() == 0) return new String[]{};

        return text.replaceAll("[,?\\-.;]", "").split("\\s+");
    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {

//        TODO write your code here
        String[] arrayWitnNulls = new String[words.length];
        int count = 0;
        for (int i = 0, j = 0; i < words.length; i++) {
            if (!hasElement(arrayWitnNulls, words[i])) {
                arrayWitnNulls[j++] = words[i];
                count++;
            }
        }

        String[] uniqueArray = new String[count];
        for (int i = 0; i < uniqueArray.length; i++) {
            uniqueArray[i] = arrayWitnNulls[i];
        }
        return uniqueArray;
    }

    public static boolean hasElement(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equalsIgnoreCase(element)) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here

        for (int i = 1; i < uniqueWords.length; i++) {
            String temp;
            if (uniqueWords[i - 1].compareTo(uniqueWords[i]) > 0) {
                temp = uniqueWords[i];
                uniqueWords[i] = uniqueWords[i - 1];
                uniqueWords[i - 1] = temp;
            }
        }

        return uniqueWords;
    }


}