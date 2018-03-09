/**
 * 
 */
package cherishIdea.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;









import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cherishIdea.common.CommonError;
import cherishIdea.common.ControllerUtil;
import cherishIdea.common.ResponseVo;
import cherishIdea.common.ResponseVoUtil;
import cherishIdea.user.domain.po.User;
import cherishIdea.user.service.IUserService;
import cherishIdea.user.service.impl.UserServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;

/***
 * Description: </br>
 * @author chenxingmei
 * @date 2017年12月29日 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	/**
	 * LOGGER *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private IUserService userServiceImpl;
	
	@Resource
	private IUserService userOutServiceImpl;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody ResponseVo login(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("登录开始");
		if (null == request) {
			LOGGER.info("request is null");
		}
		if (null == response) {
			LOGGER.info("response is null");
		}
		String ip = null;
//		if (request.getHeader("x-forwarded-for") == null) {//如果未通过nginx反向代理
//		    ip = request.getRemoteAddr();
//		} else {
//			//若通过nginx反向代理，获取客户端真实ip
//			ip = request.getHeader("x-forwarded-for");
//		}
		LOGGER.info("用户IP是：{}",ip);
		ResponseVo responseVo = ResponseVoUtil.getSuccess();
		try {
//			String string = ControllerUtil.getRequestJsonString(request);
//			LOGGER.info(string);
			
			
			request.setCharacterEncoding("UTF-8");
			//request.getContentType();
			response.setContentType("text/html");
			ServletInputStream servletInputStream = request.getInputStream();
			String paramString = IOUtils.toString(servletInputStream, "UTF-8");
			LOGGER.info(paramString);
//
//			JSONObject json = (JSONObject) JSON.parse(paramString);
	        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(servletInputStream, "UTF-8"));

			//JSONObject obj = (JSONObject) JSONObject.toJSON(input);
			//User param = JSONObject.toJavaObject(obj, User.class);
			//userServiceImpl.login(obj);
			//userOutServiceImpl.login(obj);

		} catch (Exception e) {
			LOGGER.error(CommonError.LOGIN_ERROR.errorMsg, request, response, e);
		}
		//Map<String, String[]> paramMap = request.getParameterMap();		
		//LOGGER.info("{}", paramMap.get("loginName"));
		responseVo = ResponseVoUtil.getSuccess();
		User user = new User();
		//JSONObject obj = (JSONObject) JSONObject.toJSON(user);
		//LOGGER.info("{}", obj.get("loginName"));
		LOGGER.info("登录结束");
		responseVo.setData(user);
		return responseVo;
	}
	
	@RequestMapping(value="/login1", method = RequestMethod.POST)
	//public @ResponseBody ResponseVo login(HttpServletRequest request, HttpServletResponse response) {
	public @ResponseBody ResponseVo login(User obj) {
//		if (null == request) {
//			LOGGER.info("request is null");
//		}
//		if (null == response) {
//			LOGGER.info("response is null");
//		}
		LOGGER.info("登录开始");
		try {
			//ServletInputStream input = request.getInputStream();
			//JSONObject obj = (JSONObject) JSONObject.toJSON(input);
			//User param = JSONObject.toJavaObject(obj, User.class);
			userServiceImpl.login(obj);
			userOutServiceImpl.login(obj);
            LOGGER.info("{}", obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Map<String, String[]> paramMap = request.getParameterMap();		
		//LOGGER.info("{}", paramMap.get("loginName"));
		ResponseVo responseVo = ResponseVoUtil.getSuccess();
		User user = new User();
		//JSONObject obj = (JSONObject) JSONObject.toJSON(user);
		//LOGGER.info("{}", obj.get("loginName"));
		LOGGER.info("登录结束");
		responseVo.setData(user);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("loginName", "登录名");
		map.put("password", "密码");
		return responseVo;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public @ResponseBody ResponseVo logout(HttpServletRequest request, HttpServletResponse response) {
		if (null == request) {
			LOGGER.info("request is null");
		}
		if (null == response) {
			LOGGER.info("response is null");
		}
		LOGGER.info("登出开始");
		ResponseVo responseVo = ResponseVoUtil.getSuccess();
		User user = new User();
		JSONObject obj = (JSONObject) JSONObject.toJSON(user);
		LOGGER.info("{}", obj.get("loginName"));
		LOGGER.info("登出结束");
		responseVo.setData(user);
		return responseVo;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	//public @ResponseBody ResponseVo register(HttpServletRequest request, HttpServletResponse response) {
	public @ResponseBody ResponseVo register(User param) {
		if (null == param) {
			LOGGER.info("param is null");
		}
		userServiceImpl.register(param);
		LOGGER.info("注册开始");
		ResponseVo responseVo = ResponseVoUtil.getSuccess();
		User user = new User();
		responseVo.setData(param);
		return responseVo;
	}
	
}
