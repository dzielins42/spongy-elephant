package pl.dzielins42.dmtools.generator.name;

public class ReferenceNameGeneratorItem implements NameGeneratorItem {

    private final NameGenerator value;

    public ReferenceNameGeneratorItem(NameGenerator value) {
        this.value = value;
    }

    @Override
    public String value(NameGeneratorOptions options) {
        return value.generate(options);
    }
}
