package intro;

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
        return sortWords(words);
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


        return null;
    }
    /**
     * @param words array with words
     * @return  array with unique words
     * */
    public static String[] getUniqueWords(String[] words) {

//        TODO write your code here

        return null;
    }

    /**
     * @param  uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     * */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here




        return null;
    }
}