package recursion;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Scanner;
public class GeometricSum {
	public static double findGeo(int k) {
		if(k == 0) {
			return 1;
		}else {
			return 1/(Math.pow(2, k)) + findGeo(k - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		double ans = findGeo(k);
		DecimalFormat dec = new DecimalFormat("#0.000");
		System.out.println(dec.format(ans));
	}

}
