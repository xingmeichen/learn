/**
 * 
 */
package cherishIdea.user.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cherishIdea.user.domain.po.User;
import cherishIdea.user.persistent.UserMapper;
import cherishIdea.user.service.IUserService;

/***
 * Description: </br>
 * @author chenxingmei
 * @date 2018年1月11日 
 */
@Service
public class UserServiceImpl implements IUserService {
	/**
	 * LOGGER *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;

	/***
	 * Description: </br>
	 * @author chenxingmei
	 * @date 2018年1月11日
	 */
	public void login(User param) {
		if (null == param) {
			return;
		}
		Integer id = 1;
		if (null == userMapper) {
			return;
		}
		User record = userMapper.selectByPrimaryKey(id);
		if (null == record) {
			LOGGER.info("查询不到数据！！！");
			return;
		}		
		LOGGER.info(record.getLoginName());
	}

	/***
	 * Description: </br>
	 * @author chenxingmei
	 * @date 2018年1月11日
	 */
	public void logout(User param) {
		// TODO Auto-generated method stub		
	}
	
	/***
	 * Description: 用户注册</br>
	 * @author chenxingmei
	 * @date 2018年1月17日
	 */
	public void register(User param) {
		if (null == param) {
			return;
		}
		if (null == param.getLoginName() || null == param.getPassword()) {
			return;
		}
		userMapper.insertSelective(param);
	}
	
	/***
	 * Description: 判断用户是否已经登录</br>
	 * @author chenxingmei
	 * @date 2018年1月15日
	 */
	public boolean isLogOn(User param) {
		if (null == param) {
			return false;
		}
		return true;
	}

	
}
