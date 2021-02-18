package book.ch7;

public class Array3 {

	public static void main(String[] args) {
		EmpVO eVOS[] = new EmpVO[3];
		EmpVO eVO = new EmpVO();
		eVO.setEmpno(7566);
		eVO.setEname("SMITH");
		eVO.setSal(3.14);
		eVOS[0] = eVO;
		eVO = new EmpVO();
		eVOS[1] = eVO;
		eVO = new EmpVO();
		eVOS[2] = eVO;
		for(EmpVO eVO2:eVOS) {
			System.out.println(eVO2);
			System.out.println(eVO2.getEmpno() + eVO2.getEname() + eVO2.getSal());
		}
	}

}
