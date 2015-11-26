import java.util.ArrayList;
import java.util.List;

/**
 * Created by anon on 26/11/2015.
 */
public class SubsetMatcher {
    public List<Integer> getSubsetMatchStartIndexes(String text, String subtext) {
        List<Integer> indexes = new ArrayList<Integer>();

        if(subtext.length() > text.length()){
            return indexes;
        }

        for(int posInText = 0; posInText < text.length(); posInText++){
            for(int posInSubText = 0; posInSubText < subtext.length() && (posInText + posInSubText) < text.length(); posInSubText++){
                char textChar = Character.toLowerCase(text.charAt(posInText + posInSubText));
                char subTextChar = Character.toLowerCase(subtext.charAt(posInSubText));

                if(textChar == subTextChar) {
                    if(posInSubText == subtext.length() -1) {
                        indexes.add(posInText + 1);
                    }
                } else {
                    break;
                }
            }
        }

        return indexes; //FIXME Return actual array
    }
}
