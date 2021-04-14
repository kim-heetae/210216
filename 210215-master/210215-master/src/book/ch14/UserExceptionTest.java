package book.ch14;
/*
 * API를 보는 습관을 들이자
 * 1일 1커밋 하는 습관을 만들자
 * 이번 프로젝트에서 사용자 예외 처리를 해볼것.
 */
public class UserExceptionTest {
	public void test(String[] a) throws UserException{
		System.out.println("test 실행");
		if(a.length < 1) {
			throw new UserException("아무것도 없습니다.");
		}
		else {
			throw new UserException("최종 예선.", 7000);			
		}
	}
	public static void main(String[] args) {
		UserExceptionTest uet = new UserExceptionTest();
		try {
			uet.test(args);
		}
		catch (UserException ue) {
//			ue.printStackTrace();
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[UserException]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
//			System.exit(0);
		}
		catch (Exception e) {
			e.toString();
			e.getMessage();
			e.printStackTrace();
		}
		finally {
			System.out.println("finally 호출");
		}
	}

}
