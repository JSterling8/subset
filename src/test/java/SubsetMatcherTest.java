import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Tests the SubsetMatcher class.
 *
 * @author Jonathan Sterling
 */
public class SubsetMatcherTest {
    private String testText;

    @Before
    public void setup(){
        testText = "How much wood would a Woodchuck chuck, if a Woodchuck could chuck wood?";
    }

    @Test
    public void testOneMatch1() {
        String testSubtext = "How";

        Integer[] expecteds = {1};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatch1() {
        String testSubtext = "wood";

        Integer[] expecteds = {10, 23, 45, 67};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatchCaseInsensitive1() {
        String testSubtext = "Wood";

        Integer[] expecteds = {10, 23, 45, 67};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatch2() {
        String testSubtext = "oo";

        Integer[] expecteds = {11, 24, 46, 68};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testMultiMatchCaseInsensitive2() {
        String testSubtext = "Oo";

        Integer[] expecteds = {11, 24, 46, 68};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNoMatch1() {
        String testSubtext = "wooden";

        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNoMatch2() {
        String testSubtext = "x";

        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testSpecialCharacterMatch() {
        String testSubtext = "?";

        Integer[] expecteds = {71};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testWhitespaceMatch() {
        String testSubtext = " ";

        Integer[] expecteds = {4, 9, 14, 20, 22, 32, 39, 42, 44, 54, 60, 66};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testWholeMatch() {
        String testSubtext = testText;

        Integer[] expecteds = {1};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testLargeMatch() {
        String testSubtext = testText.substring(0, 40);

        Integer[] expecteds = {1};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testSubtextTooLarge() {
        String testSubtext = "How much wood would a Woodchuck chuck, if a Woodchuck could chuck wood?a";

        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testBlankSubText() {
        String testSubtext = "";

        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNullText() {
        String testSubtext = "oo";

        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(null, testSubtext);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNullSubText() {
        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(testText, null);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }

    @Test
    public void testNullSubTextAndText() {
        Integer[] expecteds = {};
        List<Integer> actuals = SubsetMatcher.getSubsetMatchStartPositions(null, null);

        Assert.assertArrayEquals(expecteds, actuals.toArray());
    }
}
