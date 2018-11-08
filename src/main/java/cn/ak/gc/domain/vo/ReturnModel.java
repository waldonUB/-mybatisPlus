package cn.ak.gc.domain.vo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Controller类数据返回类型
 * @author waldon
 * */

public class ReturnModel implements Serializable {
	/**接口业务是否处理成功*/
	private boolean success = false;
	/** 是否需要重定向到登录界面*/
	private boolean redirectLogin = false;
	/**返回状态*/
	private int status=0;
	/**返回消息*/
	private String message;
	/**返回数据*/
	private Object data;
	/**返回多个数据*/
	private HashMap<String, Object> props = new HashMap<String, Object>();

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isRedirectLogin() {
		return redirectLogin;
	}

	public void setRedirectLogin(boolean redirectLogin) {
		this.redirectLogin = redirectLogin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public HashMap<String, Object> getProps() {
		return props;
	}

	public void setProps(HashMap<String, Object> props) {
		this.props = props;
	}
	
}
