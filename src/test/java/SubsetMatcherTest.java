import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anon on 26/11/2015.
 */
public class SubsetMatcherTest {
    private String testText;
    private SubsetMatcher subsetMatcher;

    @Before
    public void setup(){
        testText = "How much wood would a Woodchuck chuck, if a Woodchuck could chuck wood?";
        subsetMatcher = new SubsetMatcher();
    }

    @Test
    public void testOneMatch1() {
        String testSubtext = "How";

        int[] expecteds = {1};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testMultiMatch1() {
        String testSubtext = "wood";

        int[] expecteds = {10, 23, 45, 67};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testMultiMatchCaseInsensitive1() {
        String testSubtext = "Wood";

        int[] expecteds = {10, 23, 45, 67};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testMultiMatch2() {
        String testSubtext = "oo";

        int[] expecteds = {11, 24, 46, 68};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testMultiMatchCaseInsensitive2() {
        String testSubtext = "Oo";

        int[] expecteds = {11, 24, 46, 68};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testNoMatch1() {
        String testSubtext = "wooden";

        int[] expecteds = {};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testNoMatch2() {
        String testSubtext = "x";

        int[] expecteds = {};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testSpecialCharacterMatch() {
        String testSubtext = "?";

        int[] expecteds = {71};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testWhitespaceMatch() {
        String testSubtext = " ";

        int[] expecteds = {4, 9, 14, 20, 22, 32, 39, 42, 44, 54, 60, 66};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testWholeMatch() {
        String testSubtext = testText;

        int[] expecteds = {0};
        int[] actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals);
    }
}
