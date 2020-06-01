package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;
/**
 * 控制器类的基类
 * @author HP
 *
 */
public class BaseController {
	
	/**
	 * 响应到客户端的、表示操作成功的状态值
	 */
	protected static final int OK = 2000;
	/**
	 * 获取session中的用户id
	 * @param session	HttpSession 对象
	 * @return	当前登录的用户id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	/**
	 * 获取session中的用户username
	 * @param session	HttpSession 对象
	 * @return	当前登录的用户名
	 */
	protected final String getUsernameFromSession(HttpSession session) {
		return session.getAttribute("username").toString();
	}
	
}
