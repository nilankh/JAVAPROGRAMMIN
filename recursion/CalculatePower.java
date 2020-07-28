package recursion;
import java.util.Scanner;
public class CalculatePower {
	
	public static int power(int x, int n) {
		if(n == 0) {
			return 1;
		}
		return x * power(x, n - 1);
	}
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = s.nextInt();
		int n = s.nextInt();
		System.out.println(power(x, n));
	}

}
