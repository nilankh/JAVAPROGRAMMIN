package recursion;
import java.util.Scanner;
public class StringToInteger {
	
	
	public static int convertStoI(String s) {
		if(s.length() == 1) {
			return s.charAt(0) - '0';
		}
		int small = convertStoI(s.substring(0, s.length() - 1));
		int lastD = s.charAt(s.length()-1) - '0';
		return small * 10 + lastD;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(convertStoI(input));
		
		
//		String input = "1234";
//		System.out.println(input.charAt(0)-'0');
//		System.out.println(input.substring(0, input.length() - 1));
//		System.out.println(input.charAt(input.length() - 1 )- '0');
	}

}
