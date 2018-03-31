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
        int countDoubles = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j] != "_duplicate_" & words[j].toLowerCase().equals(words[i].toLowerCase())) {
                    words[j] = "_duplicate_";
                    countDoubles++;
                }
            }
        }

        String[] uniques = new String[words.length - countDoubles];
        for (int i = 0, j = 0; i < words.length; i++) {
            if (words[i] != "_duplicate_") {
                uniques[j++] = words[i];
            }
        }

        return uniques;
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here
            Arrays.sort(uniqueWords);

        return uniqueWords;
    }
}