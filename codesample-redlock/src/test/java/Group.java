

import com.google.common.collect.Lists;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Group {

    public static void main(String[] args) {
        ArrayList<AbstractMap.SimpleEntry<String, String>> indexes = Lists.newArrayList(
                new AbstractMap.SimpleEntry<>("746946688983240704", "c63fe7b5efc64ee26615b0010c96de40"),
                new AbstractMap.SimpleEntry<>("746946688983240704", "c63fe7b5efc64ee26615b0010c96de41"),
                new AbstractMap.SimpleEntry<>("746946688983240704", "c63fe7b5efc64ee26615b0010c96de42"),
                new AbstractMap.SimpleEntry<>("746946688983240701", "c63fe7b5efc64ee26615b0010c96de43"),
                new AbstractMap.SimpleEntry<>("746946688983240702", "c63fe7b5efc64ee26615b0010c96de43")
        );

        // select * from group by class
        indexes.stream()
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey))
                .entrySet().stream()
                .map(t -> {

                    Object key = t.getKey();
                    List<AbstractMap.SimpleEntry<String, String>> pkLists = t.getValue();
                    List<String> pks = pkLists
                            .stream()
                            .map(AbstractMap.SimpleEntry::getKey)
                            .collect(Collectors.toList());

                    return new AbstractMap.SimpleEntry<>(key.toString(), pks);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach(
                        (k, v) -> System.err.println(String.format("%s, %s", k, v))
                );
    }
}
