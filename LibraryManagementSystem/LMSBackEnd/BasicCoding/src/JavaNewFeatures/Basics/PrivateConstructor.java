package JavaNewFeatures.Basics;

public class PrivateConstructor {

	private static int count = 0;
	private static PrivateConstructor privateConstructor;
	int value;

	private PrivateConstructor() {
		return;
	}

	public static PrivateConstructor createConstructor() {

		if (count == 0) {
			privateConstructor = new PrivateConstructor();
			count++;
		}

		return privateConstructor;

	}
}
