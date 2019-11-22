import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest<HoratioParser> {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String input = "Hamlet loves Coding and Hamlets  Helmet is hard.";
        String actual = HamletParser.hamletReplacer(input);
        String expected = "Leon loves Coding and Leons  Helmet is hard.";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String input = "Horatio loves Coding and training tiny Horatios in Toranto.";
        String actual = HamletParser.horatioReplacer(input);
        String expected = "Tariq loves Coding and training tiny Tariqs in Toranto.";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeOpheliaToValerie() {
        String input = "Fear it, Ophelia, fear it, my dear sister. To the celestial and my soul's idol, the most beautified Ophelia.";
        String actual = HamletParser.opheliaReplacer(input);
        String expected = "Fear it, Valerie, fear it, my dear sister. To the celestial and my soul's idol, the most beautified Valerie.";;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(HamletParser.finder(hamletText, "Horatio"));
    }

    @Test
    public void testFindHoratio2() {
        Assert.assertFalse(HamletParser.finder(hamletText, "Valerie"));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(HamletParser.finder(hamletText, "Hamlet"));
    }
}