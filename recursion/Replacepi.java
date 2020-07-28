package recursion;
import java.util.Scanner;
public class Replacepi {
	
	public static String replace(String s) {
		if(s.length() == 0 || s.length() == 1) {
			return s;
		}
		if(s.charAt(0) == 'p' && s.charAt(1) == 'i') {
			String out = replace(s.substring(2));
			return "3.14" + out;
		}else {
			String out = replace(s.substring(1));
			return s.charAt(0) + out;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(replace(input));
	}

}
