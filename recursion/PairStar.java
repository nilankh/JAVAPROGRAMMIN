package recursion;
import java.util.Scanner;
public class PairStar {

	public static String pairStar(String s) {
		if(s.length() <= 1) {
			return s;
		}
//		String out = pairStar(s.substring(1));
		if(s.charAt(0) == s.charAt(1)) {
			return s.charAt(0) + "*" + pairStar(s.substring(1));
		}else {
			return s.charAt(0) + pairStar(s.substring(1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(pairStar(input));
	}

}
