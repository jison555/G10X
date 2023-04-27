package JavaNewFeatures.Basics;

public class StringClass {

	public static void main(String[] args) {

		String str = "abc";
		str="zyx";
		String str1 ="abc";
		String str2 = new String("abc");
		String str3 = new String("abc");
		System.out.println(str.hashCode());
		System.out.println(str1==str);
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
	}

}
