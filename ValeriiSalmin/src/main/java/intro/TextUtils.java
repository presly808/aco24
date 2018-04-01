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
        if ((text == null) || (text.length() == 0)){
            return new String[0];
        }
        return text.split("; ");
    }
    /**
     * @param words array with words
     * @return  array with unique words
     * */
    public static String[] getUniqueWords(String[] words) {

//        TODO write your code here

        String[] tmpArray = new String[words.length];
        int iPoint = 0;
        for (int i = 0; i < words.length; i++){
            if (!hasElement(tmpArray,words[i])){
                tmpArray[iPoint] = words[i];
                iPoint++;
            }
        }

        String[] uniqueWords = new String[iPoint];
        for (int i = 0; i < iPoint; i++) {
            uniqueWords[i] = tmpArray[i];
        }
        return uniqueWords;
    }

    public static boolean hasElement(String[] words, String element){
        for (int i=0; i < words.length; i++){
            if (words[i] != null&&words[i].equalsIgnoreCase(element)){
                return true;
            }
        }
        return false;
    }
    /**
     * @param  uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     * */
    public static String[] sortWords(String[] uniqueWords) {

//        TODO write your code here
        for (int i=0; i < uniqueWords.length; i++){
            for (int j=i+1; j < uniqueWords.length; j++){
                if (uniqueWords[i].compareTo(uniqueWords[j]) > 0){
                    String tempValue = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = tempValue;
                }
            }
        }
        return uniqueWords;
    }
}