package JavaNewFeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Coding1 {

	public static void main(String[] args) throws InterruptedException {

		
		List<Integer> listNum = Arrays.asList(10, 20, 30, 30, 30, 40, 50, 40 );
		List<String> listString = Arrays.asList("jison","james" );
//		List<Integer> map = Arrays.stream(arr).boxed()
//				.collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().filter(x-> x.getValue()==1).map(x->x.getKey()).collect(Collectors.toList());
//		System.out.println(map);
//System.out.println(list.stream().mapToInt(x->x));

//Optional<String> opt;
//opt = Optional.ofNullable(null);
//String strs =  opt.isPresent()?opt.get():"null value";
//  System.out.println(strs);
		
		listString =  listString.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(listString);



	}

}
