/**
 * 
 */
package cherishIdea.user.service;

import cherishIdea.user.domain.po.User;

/***
 * Description: </br>
 * @author chenxingmei
 * @date 2018年1月11日 
 */
public interface IUserService {

	/***
	 * Description: 用户登录</br>
	 * @author chenxingmei
	 * @date 2018年1月11日
	 */
	public void login(User param);
	
	/***
	 * Description: 用户退出</br>
	 * @author chenxingmei
	 * @date 2018年1月11日
	 */
	public void logout(User param);

	/***
	 * Description: </br>
	 * @author chenxingmei
	 * @date 2018年1月17日
	 */
	public void register(User param);
	
}
