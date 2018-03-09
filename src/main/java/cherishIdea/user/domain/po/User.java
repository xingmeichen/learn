/**
 * 
 */
package cherishIdea.user.domain.po;

import java.io.Serializable;

/***
 * Description: </br>
 * @author chenxingmei
 * @date 2017-12-29
 */
public class User implements Serializable {

	/**
	 * serialVersionUID *
	 */
	private static final long serialVersionUID = 4891571970547962696L;

	/**
	 * id 用户编号*
	 */
	private Integer id;

	/**
	 * loginName 登录名*
	 */
	private String loginName;
	
	/**
	 * password 登录密码*
	 */
	private String password;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
