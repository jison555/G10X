import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListClass {

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		List<ArrayList<Integer>> Outerlist = new ArrayList<>();
		System.out.println("enter total lines");
		int totalInputs = sc1.nextInt();
		ArrayList<Integer> totalInputIlist = new ArrayList<>();
		totalInputIlist.add(totalInputs);
		Outerlist.add(totalInputIlist);
		for (int i = 0; i < totalInputs; i++) {
			System.out.println("enter size of " + i + " th  line");
			int size = sc1.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			list.add(size);
			for (int j = 0; j < size; j++) {
				System.out.println(j + " th element in the line");
				list.add(sc1.nextInt());
			}
			Outerlist.add(list);
		}
		System.out.println(Outerlist);
		// ===================================================
		System.out.println("enter number of queries");
		int queries = sc1.nextInt();
		ArrayList<Integer> totalQueryIlist = new ArrayList<>();
		totalQueryIlist.add(queries);
		List<ArrayList<Integer>> OuterQuerylist = new ArrayList<>();
		OuterQuerylist.add(totalQueryIlist);
		for (int i = 0; i < queries; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			System.out.println("enter arrayNum");
			list.add(sc1.nextInt());
			System.out.println("enter array val");
			list.add(sc1.nextInt());
			OuterQuerylist.add(list);
		}
		System.out.println(OuterQuerylist);
		// ========================================================

		for (int i = 1; i < OuterQuerylist.size(); i++) {
			try {
			int arrNum = OuterQuerylist.get(i).get(0);
			int val = OuterQuerylist.get(i).get(1);

		
				System.out.println(Outerlist.get(arrNum).get(val));
			} catch (Exception e) {
				System.out.println("ERROR!");
			} 

		}
	}	
}
