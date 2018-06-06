package pl.dzielins42.dmtools.util.random;

import java.util.Random;

public final class RandomAdapter implements RandomProvider {

    private Random random;

    public RandomAdapter() {
        this(new Random());
    }

    public RandomAdapter(Random random) {
        if (random == null) {
            throw new IllegalArgumentException();
        }

        this.random = random;
    }

    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    public double nextDouble() {
        return random.nextDouble();
    }

    public float nextFloat() {
        return random.nextFloat();
    }

    public int nextInt() {
        return random.nextInt();
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public long nextLong() {
        return random.nextLong();
    }

    public double nextGaussian() {
        return random.nextGaussian();
    }
}