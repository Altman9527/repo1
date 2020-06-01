package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
	
	@Autowired
	private AddressService service;
	
	@Test
	public void addNew() {
		try {
			
			Integer uid = 20;
			String username="张浩";
			Address address =new Address();
			address.setName("张浩");
			service.addNew(uid, username, address);
			System.err.println("OK");
		}catch(ServiceException e){
			System.err.println(e.getClass().getName());
		}
	}
	@Test
	public void getByUid(){
		Integer uid=15;
		List<Address> addresses= service.getByUid(uid);
		for (Address address:addresses
			 ) {
			System.out.println(address);
		}
	}
	
}








