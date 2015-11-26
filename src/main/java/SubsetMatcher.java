import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for finding subtexts of texts.
 *
 * @author Jonathan Sterling
 */
public class SubsetMatcher {
    private SubsetMatcher(){
        // Class is uninstantiable...
    }

    /**
     * If a given subtext is contained, in order, within a given text, this method returns all
     * indexes of the original text where the subtext match(es) start.
     *
     * @param text      The text in which you are looking for subtext matches
     * @param subtext   The subtext which you are looking for in the text
     * @return          A List of Integers of all starting indexes where the entire subtext is contained,
     *                  in order, in the text provided.  Case is ignored for all english characters
     *                  (A-Z and a-z)  <b>(returned indexes start at 1, not 0</b>)
     */
    public static List<Integer> getSubsetMatchStartIndexes(String text, String subtext) {
        List<Integer> indexes = new ArrayList<Integer>();

        if(!areValidInputs(text, subtext)){
            return indexes;
        }

        for(int posInText = 0; posInText < text.length(); posInText++){
            for(int posInSubText = 0; posInSubText < subtext.length() && (posInText + posInSubText) < text.length(); posInSubText++){
                char textChar = toLowerCase(text.charAt(posInText + posInSubText));
                char subTextChar = toLowerCase(subtext.charAt(posInSubText));

                if(textChar == subTextChar) {
                    if(posInSubText == subtext.length() -1) {
                        indexes.add(posInText + 1);
                    }
                } else {
                    break;
                }
            }
        }

        return indexes;
    }

    private static boolean areValidInputs(String text, String subtext) {
        if(text == null ||
                subtext == null ||
                subtext.length() > text.length() ||
                subtext == ""){
            return false;
        }

        return true;
    }

    /**
     * Will only work for English unicode characters.  If you need multilingual support, use Character.toLowerCase(char c)
     *
     * @param c The character to convert to lower case
     * @return The lower case version of the character entered.
     */
    private static char toLowerCase(char c) {
        int unicodeValue = (int) c;

        // If it's A-Z
        if(unicodeValue >= 65 && unicodeValue <= 90) {
            c = (char)(unicodeValue + 32);
        }

        return c;
    }
}
