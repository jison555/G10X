import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashMapClass {

	// Write a Java program to check if a given array contains a subarray with 0
	// sum.

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14 };

		Arrays.sort(arr);

		for (int i = 1; i < arr.length-1; i += 2) {

			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;

		}
		System.out.println(Arrays.toString(arr));

	}

}
