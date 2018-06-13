package pl.dzielins42.dmtools.generator.name;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pl.dzielins42.dmtools.util.random.RandomAdapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

@RunWith(Parameterized.class)
public class ProbabilityArrayNameGeneratorTest {

    private static final long SEED = 42L;
    private static final NameGeneratorItem[] VALUES = new NameGeneratorItem[]{
            new StringNameGeneratorItem("A"), new StringNameGeneratorItem("B"), new StringNameGeneratorItem("C"), new StringNameGeneratorItem("D"), new StringNameGeneratorItem("E")
    };

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {VALUES, null}
        });
    }

    private NameGeneratorItem[] values;
    private double[] probabilities;

    private ProbabilityNameGenerator generator;
    private NameGeneratorOptions options;

    public ProbabilityArrayNameGeneratorTest(NameGeneratorItem[] values, double[] probabilities) {
        this.values = values;
        this.probabilities = probabilities;
    }

    @Before
    public void setUp() throws Exception {
        generator = new ProbabilityNameGenerator(values, probabilities);
        options = new NameGeneratorOptions(new RandomAdapter(new Random(SEED)));
    }

    @After
    public void tearDown() throws Exception {
        generator = null;
        options = null;
    }

    @Test
    public void testGenerateSingle() {
        assertNotNull(generator.generate(options));
    }

    @Test
    public void testGenerateMultiple() {
        Collection<String> result = generator.generate(options, 10);
        assertNotNull(result);
        assertEquals(result.size(), 10);
    }
}