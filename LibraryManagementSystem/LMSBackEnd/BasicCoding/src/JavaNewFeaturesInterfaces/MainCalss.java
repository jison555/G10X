package JavaNewFeaturesInterfaces;

import java.util.ArrayList;
import java.util.List;

public class MainCalss {

	public static void main(String[] args) {

		List<Vehicles> veh = new ArrayList<>();
		veh.add(new Toyoto("aaa"));
		veh.add(new Hundai("aaa"));
		Vehicles vehicle = new Vehicles() {

			@Override
			public String companyName() {
				return "gamess";
			}
		};
		System.out.println(vehicle.companyName());
		System.out.println(Vehicles.country());

		veh.stream().filter(x -> x instanceof Hundai).forEach(x -> System.out.println(x.companyName()));

	}

}
