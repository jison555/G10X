package JavaNewFeaturesInterfaces;

public class Hundai implements Vehicles {
	
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hundai(String name) {
		this.name = name;
	}

	@Override
	public String companyName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public void vehType() {
		System.out.println("hack-pack");
	}

}
