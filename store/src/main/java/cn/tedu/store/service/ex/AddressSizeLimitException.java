package cn.tedu.store.service.ex;

/**
 * 插入数据异常
 */
public class AddressSizeLimitException extends ServiceException {


	private static final long serialVersionUID = 2980764691076197110L;

	public AddressSizeLimitException() {
		super();
	}

	public AddressSizeLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressSizeLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressSizeLimitException(String message) {
		super(message);
	}

	public AddressSizeLimitException(Throwable cause) {
		super(cause);
	}

}
