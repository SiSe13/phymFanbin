package com.phym.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phym.entity.User;
import com.phym.service.UserService;
import com.phym.util.JsonResult;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
	
	private static String Url="http://106.ihuyi.cn/webservice/sms.php?method=Submit";

	@Autowired
	private UserService userService; 

	//发送验证码
	@RequestMapping("/send.do")
	public int sendCode(HttpServletRequest request,String phone){ 
				/*
				 * 根据手机号查询用户
				 * 如果有说明已经注册返回异常
				 * 省略
				 */
				HttpClient client = new HttpClient();
				PostMethod method = new PostMethod(Url);
				client.getParams().setContentCharset("UTF-8");
				method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");				
				/*
				 * 随机生成的6位验证码
				 */
				int mobile_code=(int) ((Math.random()*9+1)*100000);
				
				//发送短信内容
				String content= new String("您的验证码是:"+mobile_code+"。请在页面中提交验证码完成验证。");
				//发送请求
				NameValuePair[] data={//提交短信
						 new NameValuePair("account", "C74683282"), 
						    new NameValuePair("password", "f521ea17f244b4410f29f0ecc96bab18"), //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
						    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
						    new NameValuePair("mobile", phone), 
						    new NameValuePair("content", content),
						    new NameValuePair("format","json")
				};

				method.setRequestBody(data);				
				try {
					client.executeMethod(method);
					String SubmitResult  =method.getResponseBodyAsString();
					JSONObject jsons =  JSONObject.fromObject(SubmitResult);
					int code = (Integer) jsons.get("code");					
					if(code == 2) {
						HttpSession session = request.getSession();
						session.setAttribute(phone, mobile_code);
						session.setMaxInactiveInterval(180);
						return code;
					}
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				return 0;
	}
	
	//广告登录
	@RequestMapping("/gglogin.do")
	public JsonResult<User> login(HttpServletRequest request,String name,String password){
		User user = userService.GGlogin(name, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
		}
		return new JsonResult<User>(user);
	
	}
	//媒体登录
	@RequestMapping("/mtlogin.do")
	public JsonResult<User> MTlogin(HttpServletRequest request,String name,String password){
		User user = userService.MTlogin(name, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
		}
		return new JsonResult<User>(user);
	
	}
	
	//检测手机号
	@RequestMapping("/checkphone.do")
	public JsonResult<User> checkPhone(String phone){
		User user = userService.checkPhone(phone);
		return new JsonResult<User>(user);
	}
	
	//检查代理商编号
	@RequestMapping("/number.do")
	public JsonResult<Boolean> checkNumber(String number){
		Boolean bool = userService.checkNumber(number);
		return new JsonResult<Boolean>(bool);
	}
	
	//检测手机号
	@RequestMapping("/checkphone_r.do")
	public JsonResult<User> checkPhone_r(String phone){
		User user = userService.checkPhone_r(phone);
		return new JsonResult<User>(user);
	}
	//修改密码
	@RequestMapping("/authcode.do")
	public JsonResult<User> updatePassword(HttpServletRequest request,String phone,String auth_code,String password, String rePassword, HttpSession HttpSession){
		HttpSession session = request.getSession(); 
		String object=session.getAttribute(phone).toString();
		session.setMaxInactiveInterval(180);
		if(session==null||session.getAttribute(phone)==null){
			throw new RuntimeException("网络异常");
		}
		if(!auth_code.equals(object)){
			throw new RuntimeException("验证码不正确");
		}
		User user = userService.updatePassword(phone, auth_code, password, rePassword);
		return new JsonResult<User>(user);
	}
	
	//验证用户名
	@RequestMapping("/checkname.do")
	public JsonResult<Object> checkName(String name){
		Object n=userService.checkName(name);
		return new JsonResult<Object>(n);

	}
	
	//注册
	@RequestMapping("/register.do")
	public JsonResult<User> Register(HttpServletRequest request,String name, String phone, String password, String confirm,int type,String verifyNo,String number){
		HttpSession session = request.getSession(); 
		String object=session.getAttribute(phone).toString();
		
		if(session==null||session.getAttribute(phone)==null){
			throw new RuntimeException("网络异常");
		}
		if(!verifyNo.equals(object)){
			throw new RuntimeException("验证码不正确");
		}else{
			User user=userService.regist(name, phone, password, confirm, type,number);
			return new JsonResult<User>(user);
		}
	}
}
