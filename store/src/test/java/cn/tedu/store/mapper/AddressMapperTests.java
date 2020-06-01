package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

	@Autowired
	private AddressMapper mapper;

@Test
public void insert() {
	Address address = new Address();
	address.setName("小张同学");
	address.setUid(5);
	Integer rows=mapper.insert(address);
	
	System.err.println("rows"+rows);
}

@Test
public void countByUid() {
	Integer uid =1;
	
	Integer count=mapper.countByUid(uid);
	System.err.println(count);
}

@Test
public  void  findByUid(){
	Integer uid=12;
	List<Address>  list= mapper.findByUid(uid);
	System.err.println("count=" + list.size());
	for (Address item : list) {
		System.err.println(item);
	}
}
}
