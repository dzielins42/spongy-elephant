package pl.dzielins42.dmtools.generator.name;

public class JoinNameGenerator extends BaseNameGenerator {

    private final NameGenerator first, second;
    private final String separator;

    public JoinNameGenerator(NameGenerator first, NameGenerator second, String separator) {
        super();

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        this.first = first;
        this.second = second;
        this.separator = separator;
    }

    @Override
    public String generate(NameGeneratorOptions options) {
        StringBuilder sb = new StringBuilder();

        sb.append(first.generate(options)).append(separator).append(second.generate(options));

        return sb.toString();
    }
}
