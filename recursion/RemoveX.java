package recursion;
import java.util.Scanner;


public class RemoveX {

	public static String removeX(String s) {
		if(s.length() == 0) {
			return "";
		}
		if(s.charAt(0) == 'x') {
			return  removeX(s.substring(1));
			
		}
		return s.charAt(0) + removeX(s.substring(1));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(removeX(input));
	}

}
