package cn.tedu.store.mapper;




import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTests {

	@Autowired
	private DistrictMapper mapper;
	
	@Test
	public void findByParent() {
		String parent="86";
	 	List<District> list= mapper.findByParent(parent);
	 	System.out.println(list.size());
	 	for (District item : list) {
			System.out.println(item);
		}
	}
	@Test
	public void findNameByCode(){
		String code="320000";
		String name=mapper.findNameByCode(code);
		System.err.println(name);
	}


}
