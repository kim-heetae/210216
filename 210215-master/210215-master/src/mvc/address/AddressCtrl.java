package mvc.address;

import java.io.*;
import java.util.*;

public class AddressCtrl {

	private AddressVO returnVO = new AddressVO();
//	private AddressVO inVO = new AddressVO();

	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall";

	public AddressCtrl(/*AddressVO vo*/) {
//		this.inVO = vo;
	}

	public AddressVO send(AddressVO vo) throws Exception {
//		String command = inVO.getCommand();
		String command = vo.getCommand();
		if(_DEL == command) {
			DeleteEntity del = new DeleteEntity();
			returnVO = del.delete(vo);
		}
		else if(_INS == command) {
			RegisterEntity regi = new RegisterEntity();
			returnVO = regi.insert(vo);
		}
		else if(_MOD == command) {			
			ModifyEntity modi = new ModifyEntity();
			returnVO = modi.update(vo);
		}
		else if(_SEL == command) {
			RetrieveEntity ret = new RetrieveEntity();
			returnVO = ret.select(vo);			
		}
		return returnVO;
	}

	public AddressVO[] send() throws Exception {
//		String command = inVO.getCommand();
		AddressVO[] returnVOs = null;
		System.out.println("send() 호출 성공 - 반환타입이 AddressVO[]");
		return returnVOs;
	}
	public List<AddressVO> sendAll() throws Exception {
//		String command = inVO.getCommand();
		List<AddressVO> selectAll = null;
		System.out.println("sendAll() 호출 성공 - 반환타입이 List<AddressVO>");
		return selectAll;
	}	
}
	