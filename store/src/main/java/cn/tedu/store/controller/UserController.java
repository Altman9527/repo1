package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.UserService;
import cn.tedu.store.util.JsonResult;

@RequestMapping("users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 响应到客户端的、表示操作成功的状态值
	 */
	private static final int OK = 2000;

	// http://localhost:8080/users/reg?username=controller&password=1234
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
		// 调用业务对象执行注册
		userService.reg(user);
		// 返回成功
		return new JsonResult<>(OK);
	}

	// http://localhost:8080/users/login?username=digest&password=0000
	@RequestMapping("login")
	public JsonResult<User> login(String username, String password, HttpSession session) {
		// 日志
		System.err.println("UserController.login()");
		System.err.println("\tusername=" + username);
		System.err.println("\tpassword=" + password);
		// 调用userService.login()方法执行登录，并获取返回结果（成功登录的用户数据）
		User data = userService.login(username, password);
		// 将返回结果中的uid和username存入到Session
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		// 将结果响应给客户端
		return new JsonResult<>(OK, data);
	}

	// http://localhost:8080/users/password/change?oldPassword=0000&newPassword=8888
	@RequestMapping("password/change")
	public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
		// 日志
		System.err.println("UserController.changePassword()");
		System.err.println("\toldPassword=" + oldPassword);
		System.err.println("\tnewPassword=" + newPassword);
		// 从Session中取出uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用userService.changePassword()执行修改密码
		userService.changePassword(uid, username, oldPassword, newPassword);
		// 返回操作成功
		return new JsonResult<>(OK);
	}

	// http://localhost:8080/users/info/show
	@GetMapping("info/show")
	public JsonResult<User> showInfo(HttpSession session) {
		// 从Session中获取uid
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		// 调用userService.getInfo()获取数据
		User data = userService.getInfo(uid);
		// 响应成功及数据
		return new JsonResult<>(OK, data);
	}
	
	// http://localhost:8080/users/info/change?phone=18088180888&email=lily@tedu.cn&gender=0
	@RequestMapping("info/change")
	public JsonResult<Void> changeInfo(User user, HttpSession session) {
		// 从Session中获取uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用userService.changeInfo()修改个人资料
		userService.changeInfo(uid, username, user);
		// 响应成功
		return new JsonResult<>(OK);
	}
	
	// http://localhost:8080/users/avatar/change
	@PostMapping("avatar/change")
	public JsonResult<Void> changeAvatar(MultipartFile file) {
		// 日志
		System.err.println("UserController.changeAvatar()");
		// 注意：SpringBoot框架默认限制了上传的文件的大小
		
		// 上传的文件保存到哪个文件夹
		String parent = "d:/";
		// 上传的文件保存时使用什么文件名
		String child = "1.jpg";
		// 上传的文件保存到哪里去
		File dest = new File(parent, child);
		
		// 执行保存文件
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 响应成功
		return new JsonResult<>(OK);
	}

}






