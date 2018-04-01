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
        if (text == null || text.isEmpty()) return new String[]{};
        return text.split("; ");
    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {

//        TODO write your code here
        if (words == null || words.length == 0) return words;

        String[] uniqArray = new String[words.length];
        int k = 0;

        for (int i = 0; i < words.length; i++) {
            if (!hasElement(uniqArray, words[i])) {
                uniqArray[k] = words[i];
                k++;
            }
        }

        String[] finalUniqArray = new String[k];
        for (int i = 0; i < k; i++) {
            finalUniqArray[i] = uniqArray[i];
        }
        return finalUniqArray;
    }

    private static boolean hasElement(String[] uniqArray, String wordToCheck) {
        for (int i = 0; i < uniqArray.length; i++) {
            if (uniqArray[i] != null && uniqArray[i].equals(wordToCheck)) return true;
        }
        return false;
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here
        if (uniqueWords == null) return uniqueWords;
        //Arrays.sort(uniqueWords);
        for (int i = 0; i < uniqueWords.length - 1; i++) {
            for (int j = 0; j < uniqueWords.length - 1; j++) {
                if (uniqueWords[j].compareTo(uniqueWords[j + 1]) > 0) {
                    String temp = uniqueWords[j];
                    uniqueWords[j] = uniqueWords[j + 1];
                    uniqueWords[j + 1] = temp;
                }
            }
        }

        return uniqueWords;
    }
}