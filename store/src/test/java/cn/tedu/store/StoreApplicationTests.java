package cn.tedu.store;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}

	// https://mvnrepository.com/artifact/commons-codec/commons-codec
	
	@Test
	public void uuid() {
		for (int i = 0; i < 20; i++) {
			String uuid = UUID.randomUUID().toString();
			System.err.println(uuid);
		}
	}
	
	@Test
	public void md5() {
		String password = "123456";
		String salt = UUID.randomUUID().toString();
		System.err.println(salt);
		String result = DigestUtils.md5Hex(salt + password + salt + password + salt);
		System.err.println(result);
		
		// a
		// 0cc175b9c0f1b6a831c399e269772661
		
		// 1234
		// 81dc9bdb52d04dc20036dbd8313ed055
		// 0000
		// 4a7d1ed414474e4033ac29ccb8653d9b
		// select
		
		// 很长的一段文字
		// 16757ece0caebdf091d86f79c1fe4f0f
	}
	
}









