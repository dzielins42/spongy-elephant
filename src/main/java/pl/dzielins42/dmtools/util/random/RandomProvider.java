package pl.dzielins42.dmtools.util.random;

public interface RandomProvider {
    boolean nextBoolean();

    double nextDouble();

    float nextFloat();

    int nextInt();

    int nextInt(int bound);

    long nextLong();

    double nextGaussian();
}
