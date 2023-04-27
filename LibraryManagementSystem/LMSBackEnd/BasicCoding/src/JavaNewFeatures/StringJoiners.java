package JavaNewFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import JavaNewFeaturesInterfaces.Hundai;
import JavaNewFeaturesInterfaces.Toyoto;

public class StringJoiners {

	public static void main(String[] args) throws Exception {

		StringJoiner stj = new StringJoiner(",", "#", "!");
		stj.add("hii").add("--");
		stj.add("people");
		System.out.println(stj.toString());
		int[] arr = { 10, 70, 20, 40, 20 };

		List<Integer> numbers = Arrays.asList(4, 5, 6, 70, 1 , 70, 13);
		// comma seperation for integers
		System.out.println(numbers.stream().map(i -> i.toString()).map(StringJoiner::new).collect(Collectors.toList()));

		// find mininum number
		System.out.println(numbers.stream().min(Comparator.comparing(Integer::valueOf)).get());

		// find max number
		System.out.println(numbers.stream().max(Comparator.comparing(Integer::valueOf)).get());

		// print string length>3
		List<String> strList = Arrays.asList("ba", "matt", "perry", "john");
		System.out.println(strList.stream().filter(x -> x.length() > 3).collect(Collectors.toList()));

		// distinct elements
		System.out.println(numbers.stream().distinct().collect(Collectors.toList()));

		// sort list
		System.out.println(numbers.stream().sorted().collect(Collectors.toList()));

		// sum of all numbers
		System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());

		// cube on each elements and find greater than 50
		numbers.stream().map(x -> x * x * x).filter(x -> x > 50).forEach(x -> System.out.print(x + " "));
		System.out.println();
			// number starts with 1
		numbers.stream().map(x -> x.toString()).filter(x -> x.startsWith("1")).forEach(System.out::println);

		
		Set<Integer> set = new HashSet<>();
		numbers.stream().filter(x-> !set.add(x)).forEach(System.out::println);
		
		numbers.stream().max(Integer::compare).get();
		
		System.out.println("reduce");
		System.out.println(numbers.stream().reduce(0,(sum,element)-> sum+element,Integer::sum));
		
		Object[] obj =  numbers.stream().toArray();
		List<String> list = Arrays.asList("sam","hariKumar","vennna");
		System.out.println(list.stream().map(Hundai::new).collect(Collectors.toList()));
		
		Optional<String> opt = Optional.empty();
		System.out.println( opt.orElseGet(()-> new String("hari")));
		
		IntStream.range(1, 6).forEach(System.out::println);
		Stream.of("Aavi","Av","A").sorted().forEach(System.out::println);
		System.out.println(numbers.stream().mapToInt(x->x).min().getAsInt());
		System.out.println(list.stream().reduce((a,b)-> a.length()>b.length()?a:b
		).get());

	}

}
