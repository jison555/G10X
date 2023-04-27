package JavaNewFeatures.Basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Factorial {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 10 };

		System.out.println(
				Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

}
