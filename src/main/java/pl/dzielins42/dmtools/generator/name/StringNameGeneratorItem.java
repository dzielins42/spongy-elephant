package pl.dzielins42.dmtools.generator.name;

public class StringNameGeneratorItem implements NameGeneratorItem {

    private final String value;

    public StringNameGeneratorItem(String value) {
        this.value = value;
    }

    @Override
    public String value(NameGeneratorOptions options) {
        return value;
    }
}
