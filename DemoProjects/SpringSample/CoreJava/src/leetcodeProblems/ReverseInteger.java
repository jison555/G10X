package leetcodeProblems;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseInteger {
	
	public static void main(String[] args) {
		
		int num = -123;
	    String numStr = Integer.toString(num);

	    // Reverse the string using streams
	    if(num>=0) {
	    
	    String reversedStr = IntStream.rangeClosed(0, numStr.length() - 1)
	            .mapToObj(i -> Character.toString(numStr.charAt(numStr.length() - 1 - i)))
	            .collect(Collectors.joining());
	     num = Integer.parseInt(reversedStr);
	    }else {
		    String reversedStr = IntStream.rangeClosed(0, numStr.length() - 2)
		            .mapToObj(i -> Character.toString(numStr.charAt(numStr.length() - 1 - i)))
		            .collect(Collectors.joining());
		     num = Integer.parseInt(reversedStr);
		     num=num*-1;
	    }
	    System.out.println(num);
	}

}