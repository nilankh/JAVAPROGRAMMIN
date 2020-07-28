package recursion;
import java.util.Scanner;
public class RemoveDuplicateRecursively {
	
	public static String removeCon(String s) {
		if(s.length() <= 1) {
			return s;
		}
		String s2 = removeCon(s.substring(1));
		if(s.charAt(0) == s.charAt(1)) {
			return s2;
		}else {
			return s.charAt(0) + s2;
		}
	}
	
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = s.next();
		System.out.println(removeCon(input));
	}

}
