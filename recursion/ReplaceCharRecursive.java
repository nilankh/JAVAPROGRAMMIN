package recursion;
import java.util.Scanner;
public class ReplaceCharRecursive {
	
	
	
	public static String replaceChar(String input, char c1, char c2) {
		if(input.length() == 0) {
			return "";
		}
		String small = replaceChar(input.substring(1), c1, c2);
		if(input.charAt(0) == c1) {
			return c2 + small;
		}else {
			return input.charAt(0) + small;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char c1 = s.next().charAt(0);
		char c2 = s.next().charAt(0);
		System.out.println(replaceChar(input, c1, c2));
	}

}
