package cn.tedu.store.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

@RestControllerAdvice
public class GlobalHandleException {
	
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handleException(Throwable e) {
		JsonResult<Void> result = new JsonResult<>(e);
		
		if (e instanceof UsernameDuplicateException) {
			result.setState(4000);
		} else if (e instanceof UserNotFoundException) {
			result.setState(4001);
		} else if (e instanceof PasswordNotMatchException) {
			result.setState(4002);
		} else if (e instanceof InsertException) {
			result.setState(5000);
		} else if (e instanceof UpdateException) {
			result.setState(5001);
		}
		
		return result;
	}

}





