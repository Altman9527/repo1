package cn.tedu.store.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.util.JsonResult;

import java.util.List;


@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController{

	@Autowired
	private AddressService addressService;

	
	private static final int OK = 2000;
	
	@RequestMapping("addnew")
	public JsonResult<Void> addnew(Address address,HttpSession session){
		//从session中获取uid和username
		Integer uid=getUidFromSession(session);
		String username=getUsernameFromSession(session);
		addressService.addNew(uid, username, address);
		return new JsonResult<Void>(OK);
		
	}
	@GetMapping({"","/"})
	public JsonResult<List<Address>> getByuid(HttpSession session){
		Integer uid =getUidFromSession(session);
		List<Address> data=addressService.getByUid(uid);
		return new  JsonResult<>(OK,data);
	}


}






