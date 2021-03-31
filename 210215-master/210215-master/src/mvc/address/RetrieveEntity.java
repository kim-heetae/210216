package mvc.address;

import java.util.List;

public class RetrieveEntity {
//오버로딩에 리턴타입은 영향이 없다
	public AddressVO select(AddressVO vo) {//무조건 1개의 로우만 가능함
		System.out.println("RetrieveEntity select(vo) 호출 성공");
		return null;
	}
	public AddressVO[] select() {//n개 로우 가능함
		System.out.println("RetrieveEntity select 호출 성공");
		return null;
	}
	public List<AddressVO> selectList(AddressVO vo) {//n개 로우 가능함.
		System.out.println("RetrieveEntity selectList(vo) 호출 성공");
		return null;
	}

}
