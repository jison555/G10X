package JavaNewFeaturesInterfaces;

import java.util.function.Consumer;

public class Toyoto implements Vehicles {
	
	private String name;
	
	
	
	public Toyoto(String name) {
		this.name = name;
	}
	
	public Toyoto() {
		
	}

	@Override
	public String companyName() {
		// TODO Auto-generated method stub
		return "toyoto";
	}
	@Override
	public void vehType() {
		System.out.println("suv");
	}
	
	public String str(Consumer<String> con) {
		
		return con.toString()+"hii";
	}

}
