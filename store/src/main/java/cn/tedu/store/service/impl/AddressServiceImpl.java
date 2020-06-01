package cn.tedu.store.service.impl;




import java.util.Date;
import java.util.List;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.ex.AddressSizeLimitException;
import cn.tedu.store.service.ex.InsertException;
import sun.security.krb5.internal.HostAddresses;


/**
 * 处理用户数据的业务层实现类
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private DistrictService districtService;

	@Override
	public void addNew(Integer uid,String username, Address address) {
		Integer count= addressMapper.countByUid(uid);
		if(count>=3) {
			throw new AddressSizeLimitException();
		}
		
		Date date = new Date();
		Integer isDefault = count==0?1:0;
		
		address.setUid(uid);
		address.setIsDefault(isDefault);
		address.setCreatedUser(username);
		address.setCreatedTime(date);
		address.setModifiedUser(username);
		address.setModifiedTime(date);
		String provinceName=districtService.getNameByCode(address.getProvinceCode());
		String cityName=districtService.getNameByCode(address.getCityCode());
		String areaName = districtService.getNameByCode(address.getAreaCode());
		address.setProvinceName(provinceName);
		address.setCityName(cityName);
		address.setAreaName(areaName);
		Integer rows =	addressMapper.insert(address);
		
		if(rows!=1) {
			throw new InsertException("增加收货地址失败？");
		}
	}

	@Override
	public List<Address> getByUid(Integer uid) {
		List<Address> list= addressMapper.findByUid(uid);
		for (Address address: list) {
			address.setUid(null);
			address.setCreatedTime(null);
			address.setCreatedUser(null);
			address.setModifiedTime(null);
			address.setModifiedUser(null);
			address.setIsDefault(null);
			address.setProvinceCode(null);
			address.setCityCode(null);
			address.setAreaCode(null);
		}
		return list;
	}


}
