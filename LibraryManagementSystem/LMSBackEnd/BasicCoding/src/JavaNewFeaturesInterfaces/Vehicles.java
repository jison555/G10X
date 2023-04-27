package JavaNewFeaturesInterfaces;

@FunctionalInterface
public interface Vehicles {
	
	String name="veh";
	
	public String companyName();
	
	static String country() {
		return "Indian Registration";
	}
	
	default void vehType() {
		System.out.println();
	}
	
	

}
