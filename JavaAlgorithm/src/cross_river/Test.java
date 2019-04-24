package cross_river;

public class Test {
	public static void main(String[] args) {
		int[] arr = {0,1,2};
		int x = 5;
		String str = "0";
		mytest(arr,x,str);
		System.out.println(arr[0]);
		System.out.println(x);
		System.out.println(str);
	}

	private static void mytest(int[] a,int x,String str) {
		str = "1";
		a[0] = 3;
		x = 6;
		CrossRiver.go("");
	}
		
	
	
}
