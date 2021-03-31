package com.design.zipcode;

public class ZipcodeVO {
	int    uid_no   = 0;
	int    zipcode  = 0;
	String zdo      = null; 
	String sigu     = null; 
	String dong     = null; 
	String ri       = null; 
	String bungi    = null; 
	String aptname  = null; 
	String upd_date = null; 
	String address  = null;
	boolean chkBox;
	public ZipcodeVO() {}
	public ZipcodeVO(int uid_no, int zipcode
			, String zdo, String sigu, String dong, String ri
			, String bungi, String aptname, String upd_date, String address, boolean chkBox) {}
	public int getUid_no() {
		return uid_no;
	}
	public void setUid_no(int uid_no) {
		this.uid_no = uid_no;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getZdo() {
		return zdo;
	}
	public void setZdo(String zdo) {
		this.zdo = zdo;
	}
	public String getSigu() {
		return sigu;
	}
	public void setSigu(String sigu) {
		this.sigu = sigu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBungi() {
		return bungi;
	}
	public void setBungi(String bungi) {
		this.bungi = bungi;
	}
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isChkBox() {
		return chkBox;
	}
	public void setChkBox(boolean chkBox) {
		this.chkBox = chkBox;
	}
	
}
