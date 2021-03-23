package thread.bakery;

import java.util.Vector;

public class BakerStack {
	private Vector<String> v = new Vector<>();
	public synchronized String pop() {
		String bread = null;
		if(v.size() == 0) {
			try {
				System.out.println("빵이 더 이상 없습니다.");
				this.wait();
			} catch (Exception e) {
				System.out.println("BakerStack pop: " + e.toString());
			}
		}
		bread = v.remove(v.size() - 1);
		return bread;
	}
	
	public synchronized void push(String bread) {
		System.out.println("빵 가져가세요");
		this.notify();
		v.add(bread);
	}
	
}
