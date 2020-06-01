package cn.tedu.store.service;

import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {
	@Autowired
	private DistrictService service;
	
	@Test
	public void getByParent() {
		
		String parent ="86";
		List<District> list=service.getByParent(parent);
		System.out.println(list.size());
		for (District item : list) {
			System.out.println(item);
		}
	}
	@Test
	public void findNameByCode(){
		String code ="320000";
		String name= service.getNameByCode(code);
		System.err.println(name);
	}

}

