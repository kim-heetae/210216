package practice.com;

public class ArrayTest {
	int[] a = new int[3];
	public static void main(String[] args) {
		ArrayTest q = new ArrayTest();
		q.a[0] = 1;
		q.a[1] = 2;
		q.a[2] = 3;
		for(int i = 0; i < q.a.length;i++) {
			System.out.println(q.a[i]);			
		}
		q.a = new int[3];
		for(int i = 0; i < q.a.length;i++) {
			System.out.println(q.a[i]);			
		}		
	}

}
