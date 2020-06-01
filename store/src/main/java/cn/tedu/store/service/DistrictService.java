package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;

public interface DistrictService {

	List<District> getByParent(String parent);
	/**
	 * 根据省/市/区的行政代号查询名称
	 * @param code 省/市/区的行政代号
	 * @return 省/市/区的名称，如果没有匹配的数据，则返回null
	 */
	String getNameByCode (String code);
}
