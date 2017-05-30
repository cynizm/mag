package sample.Model;

import sample.Common.Algorithm;

import java.io.File;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleEncoding extends Algorithm<String>{

    private static final Map<String, String> dictionary = Stream.of(
            new AbstractMap.SimpleEntry<>("00", "A"),
            new AbstractMap.SimpleEntry<>("01", "T"),
            new AbstractMap.SimpleEntry<>("10", "C"),
            new AbstractMap.SimpleEntry<>("11", "G"))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

    private static final String name = "Simple Encoding";


    public SimpleEncoding(File file) {
        super(file);
    }

    public SimpleEncoding(){
        super();
    }

    @Override
    public void convert() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(bitRepresentationInput.split("(?<=\\G.{2})")).forEach(p -> builder.append(dictionary.get(p)));
        dnaRepresentationOutput = builder.toString();
    }

    @Override
    public String toString() {
        return name;
    }

}
