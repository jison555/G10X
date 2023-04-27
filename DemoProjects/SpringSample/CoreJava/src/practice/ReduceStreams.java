package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReduceStreams {

	public static int fun1(int x) {
		return x;
	}

	public static int sum(int x, int y) {
		return x + y;
	}

	public static void main(String[] args) {

//		int[] a = { 1, 5, 2};
//
//		int sum = Arrays.stream(a).reduce(0, (c, b) -> c + b);
//		System.out.println("sum = " + sum);
//
//		Map<Integer, Long> map = Arrays.stream(a).boxed()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println("map = " + map);
//		
//		System.out.println(Arrays.stream(a).boxed().collect(Collectors.toMap(x->x, x->x*2)));
//		
//
//		HashSet<Integer> hs = new HashSet<>();
//
//		List<Integer> list = Arrays.stream(a).sorted().boxed().filter(x -> !hs.add(x)).collect(Collectors.toList());
//
//		System.out.println("list  ="+list);
		// find the greatest value
//		System.out.println(Arrays.stream(a).reduce((x, y) -> x > y ? x : y).getAsInt());
//		// find the sum value
//		System.out.println(Arrays.stream(a).reduce(ReduceStreams::sum).getAsInt());
//		// find the greatest value with initial value
//		System.out.println(Arrays.stream(a).reduce(0, (x, y) -> x + y));
//		//find the product

//		System.out.println(Arrays.stream(a).reduce((x, y) -> x * y).getAsInt());

//
//		Arrays.stream(a).map(ReduceStreams::fun1).forEach(System.out::print);
//		System.out.println();
//		
//		//==========================================================================
//		
//		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
////		System.out.println(letters.stream().reduce((let1,let2) -> let1+let2.toUpperCase()));
//		letters.stream().collect(Collectors.toList());
//		letters.stream().collect(Collectors.toSet());
//		System.out.println(letters.stream().collect(Collectors.toMap(x -> x, x -> x)));

		int[] arr = { 10, 70, 30, 90 };
		int[] arr1 = { 90, 30, 10, 70,10};
		
		HashSet<Integer> hs = new HashSet<>();
		Arrays.stream(arr).filter(x-> hs.add(x)).count();
		Arrays.stream(arr1).filter(x-> hs.add(x)).count();
		if(arr.length==arr1.length) {
			if(arr.length==hs.size()) {
				System.out.println("same elements");
			}
		}

	}

}
