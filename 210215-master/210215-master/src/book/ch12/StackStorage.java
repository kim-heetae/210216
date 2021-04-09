package book.ch12;

import java.util.Stack;

public class StackStorage {

	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
//		st.peek();
		st.add("꽈배기");
		st.add("도너츠");
		System.out.println(st.peek());
	}

}
