package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.District;
import cn.tedu.store.service.DistrictService;
import cn.tedu.store.util.JsonResult;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
	
	@Autowired
	DistrictService service;
	
	@GetMapping({"","/"})
	public JsonResult<List<District>> getByParent(String parent){
		List<District> result =service.getByParent(parent);
		return new JsonResult<>(OK,result);
		
	}
}
