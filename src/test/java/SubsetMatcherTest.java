import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

        Integer[] expecteds = {1};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatch1() {
        String testSubtext = "wood";

        Integer[] expecteds = {10, 23, 45, 67};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatchCaseInsensitive1() {
        String testSubtext = "Wood";

        Integer[] expecteds = {10, 23, 45, 67};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatch2() {
        String testSubtext = "oo";

        Integer[] expecteds = {11, 24, 46, 68};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatchCaseInsensitive2() {
        String testSubtext = "Oo";

        Integer[] expecteds = {11, 24, 46, 68};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNoMatch1() {
        String testSubtext = "wooden";

        Integer[] expecteds = {};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNoMatch2() {
        String testSubtext = "x";

        Integer[] expecteds = {};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testSpecialCharacterMatch() {
        String testSubtext = "?";

        Integer[] expecteds = {71};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testWhitespaceMatch() {
        String testSubtext = " ";

        Integer[] expecteds = {4, 9, 14, 20, 22, 32, 39, 42, 44, 54, 60, 66};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testWholeMatch() {
        String testSubtext = testText;

        Integer[] expecteds = {0};
        List<Integer> actuals = subsetMatcher.getSubsetMatchStartIndexes(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }
}
