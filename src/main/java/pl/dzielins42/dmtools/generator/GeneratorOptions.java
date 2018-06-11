package pl.dzielins42.dmtools.generator;

import pl.dzielins42.dmtools.util.random.RandomProvider;

public class GeneratorOptions implements RandomProvider{

    private final RandomProvider random;

    public GeneratorOptions(RandomProvider random) {
        super();

        if (random == null) {
            throw new IllegalArgumentException();
        }

        this.random = random;
    }

    public RandomProvider getRandom() {
        return random;
    }

    @Override
    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    @Override
    public double nextDouble() {
        return random.nextDouble();
    }

    @Override
    public float nextFloat() {
        return random.nextFloat();
    }

    @Override
    public int nextInt() {
        return random.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    @Override
    public long nextLong() {
        return random.nextLong();
    }

    @Override
    public double nextGaussian() {
        return random.nextGaussian();
    }

}
