package pl.dzielins42.dmtools.generator.name;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseNameGenerator implements NameGenerator {

    @Override
    public Collection<String> generate(NameGeneratorOptions options, int count) {
        List<String> result = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            result.add(generate(options));
        }

        return result;
    }
}
