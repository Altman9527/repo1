package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
/**
 * 处理省市区数据的持久层接口
 * @author HP
 *
 */
public interface DistrictMapper {
	/**
	 * 获取全国所有省 获取某省所有市  获取某市所有区
	 * @param parent 父级单位的行政代号，如果获取某市所有区的列表，
	 * 该参数应该市市的行政代号 
	 * @return 全国所有省  或某省所有市 或某市所有区
	 */
	List<District> findByParent(String parent);

	/**
	 * 根据省市区的代号进行查询
	 * @param code 省市区行政代号
	 * @return	省市区的名称 如果没有查询到返回null
	 */
	String findNameByCode(String code);
	
	
	

}
