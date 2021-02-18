package book.ch7;
//EmpVO는 1개의 ROW만 담을수 있다. - 배열이라니라 변수이기 때문에
public class EmpVO {
	private int empno = 0;
	private String ename = null;
	private double sal = 0.0;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
}
