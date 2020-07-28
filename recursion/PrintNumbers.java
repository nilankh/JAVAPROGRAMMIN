package recursion;
import java.util.Scanner;
public class PrintNumbers {
	
	public static void print(int n) {
		if(n == 0) {
			return;
		}
		print(n - 1);
		System.out.print(n + " ");
	}
	
	
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = s.nextInt();
		print(n);
	}

}
