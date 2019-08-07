package java8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StreamTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamTest.class);

    @Test
    public void streamRange() {
        ArrayList<Integer> testArrayList = (ArrayList<Integer>) IntStream.range(1, 10).boxed().collect(Collectors.toList());
        assertEquals(9, testArrayList.size());
    }

    @Test
    public void streamRangeSkip() {
        ArrayList<Integer> testArrayList = (ArrayList<Integer>) IntStream
                .range(1, 10)
                .skip(5)
                .boxed()
                .collect(Collectors.toList());
        testArrayList.stream().forEach(System.out::println);

        assertEquals(4, testArrayList.size());
    }

    @Test
    public void streamRangeSum() {
        IntStream
                .range(1, 10)
                .sum();

        assertEquals(4950, IntStream
                .range(0, 100)
                .sum());
    }

    @Test
    public void streamOfFindFirst() {
        ArrayList<String> list = new ArrayList<>();
        list.add("CAR");
        list.add("BUS");
        list.add("AIRPLANE");
        list.add("AAIRBUS");

        Optional<String> str = list.stream()
                .sorted()
                .findFirst();

        assertEquals(true, str.isPresent());
        assertEquals("AAIRBUS", str.get());
    }

    @Test
    public void streamOfVector() {
        String[] listNames = {"Finland", "Russia", "Latvia", "Lithuania", "Poland"};
        Set<String> set = Arrays.stream(listNames)
                .filter(name -> name.startsWith("L"))
                .collect(Collectors.toSet());

        assertEquals(false, set.isEmpty());
        assertEquals("Latvia", set.iterator().next());
    }

    @Test
    public void streamOfSetInteger() {
        Set<Double> set = Arrays.stream(new Integer[] {100,30,500,60,300,140})
                .map(value -> value * 0.5)
                .filter(value -> value < 80)
                .collect(Collectors.toSet());

        assertEquals(false, set.isEmpty());
        assertEquals(Optional.of(70.0), Optional.of(set.iterator().next()));
    }

    @Test
    public void streamOfSetIntAverage() {
        assertEquals(OptionalDouble.of(14), Arrays.stream(new int[] {1,3,5,6,3,2})
                .map(value -> value * value)
                .average()
        );
    }

    @Test
    public void streamOfVectorMapLowerCase() {
        String[] listNames = {"FINLAND", "RUSIA", "SUIZA", "POLONIA", "FRANCIA", "ALEMANIA"};
        ArrayList<String> lowerCaseList = (ArrayList<String>) Arrays.stream(listNames)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        assertArrayEquals(new String[]{"finland", "rusia", "suiza", "polonia", "francia", "alemania"}, lowerCaseList.toArray());
    }

    @Test
    public void streamOfFile() throws IOException, URISyntaxException {

        //Paths.get("C:\\Users\\carlos.arias\\Desktop\\TALENT_POD_JULIO2019\\SAMPLECODE\\restSample\\src\\test\\resources\\cities.txt")
        ArrayList<String> cities = (ArrayList<String>) Files.lines((Paths.get(StreamTest.class.getResource("/cities.txt").toURI())))
                .filter(city -> city.contains("R"))
                .collect(Collectors.toList());

        assertEquals(224,cities.size());
    }

    @Test
    public void streamOfString() throws IOException, URISyntaxException {

        Stream<String> cities = Files.lines((Paths.get(StreamTest.class.getResource("/cities.txt").toURI())));

        int count = (int) cities.filter(city -> city.contains("R"))
                .count();

        assertEquals(224,count);
    }

    @Test
    public void streamOfDataCsv() throws IOException, URISyntaxException {

        Stream<String> cities = Files.lines((Paths.get(StreamTest.class.getResource("/data.txt").toURI())));

        Map<String, Integer> mapCities = new HashMap<String, Integer>();

        mapCities = cities
                .map(row -> row.split(","))
                .filter(row -> row.length>2)
                .collect(Collectors.toMap(row -> row[0],
                        row -> Integer.parseInt(row[1])));
        cities.close();

        List<Set<String>> listKeys = Stream.of(mapCities.keySet()).collect(Collectors.toList());
        assertEquals(3,listKeys.get(0).size());
        assertEquals("YAOUNDE",listKeys.get(0).toArray()[0]);
        assertEquals("YOKOHAMA",listKeys.get(0).toArray()[1]);
        assertEquals("WINNIPEG",listKeys.get(0).toArray()[2]);
        assertEquals(Optional.ofNullable(20), Optional.ofNullable(mapCities.get("YOKOHAMA")));
    }

    @Test
    public void streamOfReduce(){
        double total = Stream.of(7.3,5.1,4.8)
                .reduce(0.0,(Double a, Double b) -> a + b);

        assertEquals(17.2,total,1);
    }

    @Test
    public void streamOfIntSummaryStatistics(){
        IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10)
                .summaryStatistics();

        assertEquals(7,summary.getCount(),0);
        assertEquals(203,summary.getSum(),0);
        assertEquals(2,summary.getMin(),0);
        assertEquals(29,summary.getAverage(),0);
        assertEquals(88,summary.getMax(),0);
    }

}

