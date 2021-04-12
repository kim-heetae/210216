package book.ch14;

public class CalendarPage {
	/**************************************************
	 * 
	 * @param mm 0~11사이에 숫자를 받는다.
	 * @param yy 출력하고자 하는 달력의 년도 입력 받기
	 **************************************************/
	public void print(int mm, int yy) throws Exception{
		System.out.println("print 호출 성공");
		if(mm < 0 || mm > 11) {
			throw new IllegalArgumentException("must be 0 ~ 11");
		}
		System.out.println("여기");
	}
	public static void main(String[] args) {
		CalendarPage cp = new CalendarPage();
		if(args.length == 2) {
			try {
				cp.print(Integer.parseInt(args[0]) - 1, Integer.parseInt(args[1]));
			}
			catch (NumberFormatException e) {
				System.out.println("NumberFormarException" + e.toString());
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println("Exception" + e.toString());
				e.printStackTrace();
			}
		}
		else {
			System.out.println("달과 년도를 입력하세요.");
			return;
		}
	}

}
