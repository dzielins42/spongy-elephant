package pl.dzielins42.dmtools.generator;

import java.util.Collection;

public interface Generator<TYPE, OPTIONS extends GeneratorOptions> {

    TYPE generate(OPTIONS options);

    Collection<TYPE> generate(OPTIONS options, int count);

}
