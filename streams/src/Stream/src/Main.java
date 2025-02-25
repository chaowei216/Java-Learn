import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("alice", "Dob", "Charlie");

        // init stream
        var stream = names.stream();

        // traversal
        stream.forEach(System.out::println);

        // Stream.of()
        var stream1 = Stream.of(names);
        stream1.forEach(System.out::println);

        // generate & iterate
        Stream<Double> randomNums = Stream.generate(Math::random).limit(5);
        randomNums.forEach(System.out::println);

        Stream<Integer> nums = Stream.iterate(1, n -> n + 2).limit(5);
        nums.forEach(System.out::println);

        //
        List<String> filteredNames = names.stream()
                .filter(n -> n != null)
                .sorted(Comparator.comparing(String::toUpperCase, Comparator.naturalOrder()))
                .toList();
        filteredNames.forEach(System.out::println);

        // reduce
        Stream<Integer> nums1 = Stream.iterate(1, n -> n + 2).limit(5);
        int sum = nums1.reduce(0, Integer::sum);
        System.out.println(sum);
    }
}