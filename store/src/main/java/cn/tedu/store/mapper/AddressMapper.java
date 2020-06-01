package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;

import java.util.List;

/**
 * 处理收货地址持久层接口
 * @author HP
 *
 */
public interface AddressMapper {
	
	/**
	 * 插入收获地址
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer insert(Address	address);
	/**
	 * 统计某个用户的收货地址数量
	 * @param uid 用户的uid
	 * @return 该用户收货地址的数量
	 */
	Integer countByUid(Integer uid);

	/**
	 * 查询某用户的收货地址列表
	 * @param uid 用户的uid
	 * @return	该用户的收货地址列表
	 */
	List<Address> findByUid(Integer uid);

}
