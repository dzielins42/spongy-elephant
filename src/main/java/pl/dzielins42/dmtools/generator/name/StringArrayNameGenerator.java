package pl.dzielins42.dmtools.generator.name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringArrayNameGenerator extends BaseNameGenerator {

    private String[] values;
    private double[] probabilities;

    public StringArrayNameGenerator(String[] values) {
        this.values = values;
        this.probabilities = new double[this.values.length];
        Arrays.fill(this.probabilities, 1.0d / this.values.length);
    }

    public StringArrayNameGenerator(String[] values, double[] probabilities) {
        if (values == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        double[] safeProbabilities = probabilities;
        if (safeProbabilities == null) {
            safeProbabilities = new double[values.length];
            Arrays.fill(safeProbabilities, 1.0d / values.length);
        }
        if (values.length != safeProbabilities.length) {
            throw new IllegalArgumentException("Lengths of values and probabilities not equal");
        }
        this.values = values;
        this.probabilities = normalize(safeProbabilities);
    }

    @Override
    public String generate(NameGeneratorOptions options) {
        final double randomValue = options.nextDouble();
        double sum = 0;

        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
            if (randomValue < sum) {
                return values[i];
            }
        }

        // Should not happen, but may be caused by floating point inequality
        // problem
        return values[values.length - 1];
    }

    private double[] normalize(double[] values) throws IllegalArgumentException {
        double sum = 0d;
        final int len = values.length;
        double[] out = new double[len];
        for (double value : values) {
            if (value < 0 || Double.isNaN(value) || Double.isInfinite(value)) {
                throw new IllegalArgumentException();
            }
            sum += value;
        }
        if (sum == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < len; i++) {
            out[i] = values[i] * 1.0d / sum;
        }
        return out;
    }
}
