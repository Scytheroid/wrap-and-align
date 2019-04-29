package cz.alisma.alej.text.wrapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AlignerTest {
    private final static List<String> TEXT = Arrays.asList("ABC", "abc", "ABC");    // Length of the complete string is 11

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new LeftAligner(), TEXT, 5, TEXT},                     // Left-side aligning
                {new RightAligner(), TEXT, 5, "     " + TEXT},          // Right-side Aligning
                {new CenterAligner(), TEXT, 4, "  " + TEXT + "  "},     // Center-gravity aligning w/ even spaces
                {new CenterAligner(), TEXT, 5, "  " + TEXT + "   "},    // Center-gravity aligning w/ odd spaces
                {new CenterAligner(), TEXT, 0, TEXT},                   // Center-gravity aligning with no spaces
                {new FillAligner(), TEXT, 6,                            // Fill-aligning with commensurable n. of spaces
                        TEXT.get(0) + "   " + TEXT.get(1) + "   " + TEXT.get(2)},
                {new FillAligner(), TEXT, 5,
                        TEXT.get(0) + "   " + TEXT.get(1) + "  " + TEXT.get(2)}

        });
    }

    private Aligner aligner;
    private List<String> text;
    private int fillLen;
    private String answer;

    public AlignerTest(Aligner aligner, List<String> text, int fillLen, String answer) {
        this.aligner = aligner;
        this.text = text;
        this.fillLen = fillLen;
        this.answer = answer;
    }

    @Test
    public void test() {
        assertEquals(answer, aligner.format(text, fillLen));
    }




}
