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
public class StringArrayNameGeneratorTest {

    private static final long SEED = 42L;
    private static final String[] VALUES = new String[]{
            "A", "B", "C", "D", "E"
    };

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {VALUES, null}
        });
    }

    private String[] values;
    private double[] probabilities;

    private StringArrayNameGenerator generator;
    private NameGeneratorOptions options;

    public StringArrayNameGeneratorTest(String[] values, double[] probabilities) {
        this.values = values;
        this.probabilities = probabilities;
    }

    @Before
    public void setUp() throws Exception {
        generator = new StringArrayNameGenerator(values, probabilities);
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