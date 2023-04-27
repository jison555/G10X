package JavaNewFeatures.Basics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class MainClass {

	public static void main(String[] args)  {
//		Runnable run = () -> {
//			for(int i=0;i<3;i++) {
//				System.out.println("t1 "+i);
//				//Thread.sleep(3000);
//			}
//		};
//		Runnable run2 = () -> {
//			for(int i=0;i<3;i++) {
//				System.out.println("t2 "+i);
//				
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		};	
//		Thread t1 = new Thread(run);
//		Thread t2 = new Thread(run2);
//		t2.join();
//		t1.start();
//		t2.start();

		
		HashMap<Integer, String> hp = new HashMap<>();
		
		hp.put(3, "Jison");
		hp.put(4, "Nima");
		hp.put(null, "Vishnu");
		hp.put(1, "Gokul");
		Set<Entry<Integer, String>> set =  hp.entrySet();
		for(Entry<Integer, String> entry:set) {
			System.out.println(entry.getKey()+" = "+entry.getValue());
		}
		Iterator<Entry<Integer, String>> itr=set.iterator();
		while(itr.hasNext()) {
			Entry<Integer, String> ent= itr.next();
			//ent.
		}


	}

}