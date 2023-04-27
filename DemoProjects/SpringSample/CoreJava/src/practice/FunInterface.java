package practice;

@FunctionalInterface
public interface FunInterface {
	
	public void demo();
	
	public default void display() {
		System.out.println("display default of demo interface ");
	}
	
	public static void print() {
		System.out.println("static print of demo interface ");
	}

}
