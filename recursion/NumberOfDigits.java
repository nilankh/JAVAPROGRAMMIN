package recursion;
import java.util.Scanner;
public class NumberOfDigits {
	
	public static int count(int n) {
		if(n == 0) {
			return 0;
		}
		int smallAns = count(n / 10);
		return smallAns + 1;
	}
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = s.nextInt();
		System.out.println(count(n));
	}

}
