package arraylist;
import java.util.ArrayList;

public class Rough {
	
	public static ArrayList<Integer> removecd(int arr[]){
		ArrayList<Integer> result = new ArrayList<>();
		result.add(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				result.add(arr[i]);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,10,20,20,30,30,40};
		ArrayList<Integer> result = removecd(arr);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
