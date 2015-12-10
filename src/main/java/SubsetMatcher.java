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
     * Matches the subtext against the text, outputting the character positions of the beginning of each
     * match for the subtext within the text.
     *
     * @param text      The text in which you are looking for subtext matches
     * @param subtext   The subtext which you are looking for in the text
     * @return          A List of Integers of all starting positions where the entire subtext is contained,
     *                  in order, in the text provided.  Case is ignored for all english characters
     *                  (A-Z and a-z)  <b>(returned positions start at 1, not 0</b>)
     */
    public static List<Integer> getSubsetMatchStartPositions(String text, String subtext) {
        List<Integer> positions = new ArrayList<Integer>();

        if(!areValidInputs(text, subtext)){
            return positions;
        }

        for(int posInText = 0; posInText < text.length() && posInText + subtext.length() <= text.length(); posInText++){
            for(int posInSubText = 0;
                posInSubText < subtext.length() && (posInText + posInSubText) < text.length();
                posInSubText++){

                char textChar = toLowerCase(text.charAt(posInText + posInSubText));
                char subTextChar = toLowerCase(subtext.charAt(posInSubText));

                if(textChar == subTextChar) {
                    if(posInSubText == subtext.length() -1) {
                        positions.add(posInText + 1);
                    }
                } else {
                    break;
                }
            }
        }

        return positions;
    }

    private static boolean areValidInputs(String text, String subtext) {
        if(text == null ||
                subtext == null ||
                subtext.length() > text.length() ||
                subtext.equals("")){
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
