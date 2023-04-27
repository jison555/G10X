package JavaNewFeatures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class SampleQuestions {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(50, 20, 10);
		System.out.println(list.stream().mapToInt(x -> x).average());
		Set<Integer> ss = new HashSet<>();

//System.out.println(	list.stream().filter(n-> list.stream().filter(x-> x==n).count()>1).distinct().collect(Collectors.toList()));
		System.out.println(list.stream().filter(x -> !ss.add(x)).distinct().collect(Collectors.toList()));
		System.out.println(list.stream().mapToInt(x -> x).average());

//System.out.println(list.stream().map(x->list.stream().map(n->x*n).mapToInt(y->y).sum()).mapToInt(z->z).sum());

		String strq = "javaCoding";
		String[] strArr = strq.split("");
		List<String> li = Arrays.asList(strArr);
		Set<String> hs = new HashSet<>();
//System.out.println(li.stream().filter(x-> li.stream().filter(n->n.equalsIgnoreCase(x)).count()<2).findFirst().get());

		for (int i = 0; i < strq.length(); i++) {
			for (int j = i; j < strq.length(); j++) {
				System.out.print(strq.substring(i, j + 1) + "  ");
			}
		}

//String str = "Hello, world!";
//IntStream.range(0, str.length())
//         .flatMap(i -> IntStream.rangeClosed(i + 1, str.length())
//                                .map(j -> str.substring(i, j)))
//         .forEach(System.out::println);
		System.out.println();
//IntStream.range(0, strq.length()).flatMap(i-> IntStream.rangeClosed(i+1, strq.length())
//		.mapToObj(j-> strq.substring(i, j)).forEach(System.out::println));

		int[] arr = {5,4,10,6,3,8};
		
		int smallest = Arrays.stream(arr).sorted().reduce((a,b)->a<b?a:b).getAsInt();
		System.out.println("smallest = "+smallest);
		arr =  Arrays.stream(arr).sorted().toArray();
		System.out.println(arr.length);
		
//		for(int i=0;i<arr.length-1;i++) {
//			if(arr[i+1]!=arr[i]+1) {
//				System.out.println(arr[i]+1);
//			}
//		}
	}

}
