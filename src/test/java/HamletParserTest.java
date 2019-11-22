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
    public void testFindHoratio() {
        String value = hamletText;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(value);
        Assert.assertTrue(matcher.find());
    }

    @Test
    public void testFindHamlet() {
        String value = hamletText;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(value);
        Assert.assertTrue(matcher.find());

    }
}