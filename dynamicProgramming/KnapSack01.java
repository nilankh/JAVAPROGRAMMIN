//0 1 Knapsack - Problem
//Send Feedback
//A thief robbing a store and can carry a maximal weight of W into his knapsack. There are N items and 
// item weigh wi and is value vi. What is the maximum value V, that thief can take ?
//Input Format :
//Line 1 : N i.e. number of items
//Line 2 : N Integers i.e. weights of items separated by space
//Line 3 : N Integers i.e. values of items separated by space
//Line 4 : Integer W i.e. maximum weight thief can carry
//Output Format :
//Line 1 : Maximum value V
//Constraints
//1 <= N <= 20
//1<= wi <= 100
//1 <= vi <= 100
//Sample Input 1 :
//4
//1 2 4 5
//5 4 8 6
//5
//Sample Output :
//13


package dynamicProgramming;
import java.util.Scanner;
public class KnapSack01 {

	
	
	public static int knapsackRec(int[] weight,int value[],int maxWeight, int n){
		return knapsackRecHelper(weight, value, maxWeight, 0);
	}
	public static int knapsackRecHelper(int[] weight,int value[],int maxWeight, int i){
		
		if(i == value.length ) {
			return 0;
		}
		
		int ans;
		if(weight[i] <= maxWeight) {
//			Includign ith item
			int ans1 = value[i] + knapsackRecHelper(weight, value, maxWeight - weight[i], i + 1);
//		Excluding ith item
			int ans2 = knapsackRecHelper(weight, value, maxWeight, i + 1);
			ans = Math.max(ans1, ans2);
		}else {
			ans = knapsackRecHelper(weight, value, maxWeight, i + 1);
			
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for(int i = 0; i < n; i++) {
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for(int i = 0; i < n; i++) {
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(knapsackRec(weight, value, maxWeight, n));
	}

}
