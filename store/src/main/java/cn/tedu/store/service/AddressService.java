package cn.tedu.store.service;

import cn.tedu.store.entity.Address;

import java.util.List;

/**
 * 处理用户数据的业务接口
 */
public interface AddressService {
	
	/**
	 * 用户注册
	 * @param user 客户端提交的用户数据
	 */
	void addNew(Integer uid,String username, Address address);

	/**
	 * 查询用户的收货地址列表
	 * @param uid 用户的id
	 * @return	该用户的收货地址列表
	 */
	List<Address>  getByUid(Integer uid);

}








