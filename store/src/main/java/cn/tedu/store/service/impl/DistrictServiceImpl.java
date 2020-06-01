package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.DistrictService;
@Service
public class DistrictServiceImpl implements DistrictService{
	@Autowired
	private DistrictMapper mapper;
	@Override
	public List<District> getByParent(String parent) {
		List<District> result = mapper.findByParent(parent);
		for (District district : result) {
			district.setId(null);
			district.setParent(null);
		}
		
		return result;
	}

	@Override
	public String getNameByCode(String code) {
		return mapper.findNameByCode(code);
	}


}
