package recursion;
import java.util.Scanner;
public class CheckPalindrome {
	public static boolean helper(String input, int si, int ei) {
		if(si > ei) {
			return true;
		}
		if(input.charAt(si) == input.charAt(ei)) {
			boolean small = helper(input, si + 1, ei - 1);
			if(small) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public static boolean isStringPalindrome(String input) {
		return helper(input, 0, input.length() - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(isStringPalindrome(input));
	}

}
