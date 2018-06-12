package pl.dzielins42.dmtools.generator.name;

public class PartsNameGenerator extends BaseNameGenerator {

    private NameGenerator[] generators;

    public PartsNameGenerator(NameGenerator... generators) {
        super();
        this.generators = generators;
    }

    @Override
    public String generate(NameGeneratorOptions options) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < generators.length; i++) {
            sb.append(generators[i].generate(options));
        }

        return sb.toString();
    }
}
