package com.phym.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/**
	 *  广告主登录
	 */
	@PostMapping("/login.do")
	public JsonResult<User> login(HttpServletRequest request,String name,String password){
		User user = userService.login(name, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
		}
		return new JsonResult<User>(user);
	}
	
	/**
	 *媒体主登录
	 */
	@PostMapping("/media.do")
	public JsonResult<User> media(HttpServletRequest request,String name,String password){
		User user = userService.media(name, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
		}
		return new JsonResult<User>(user);
	}
	@RequestMapping("/heartbeat.do")
	//心跳检测控制器方法，目的保持session的新鲜
	public JsonResult<String> heartbeat(){
		//System.out.println("OK"); 
		return new JsonResult<String>("OK");
	}
	
	/**
	 *  修改密码
	 */
	@RequestMapping("/authcode.do")
	public int authCode(HttpServletRequest request,String phone,String verifyNo,String password,String rePassword){
		HttpSession session = request.getSession(); 
		String object=session.getAttribute(phone).toString();
		if(session==null||session.getAttribute(phone)==null){
			throw new RuntimeException("网络异常");
		}

		if(!verifyNo.equals(object)){
			throw new RuntimeException("验证码不正确");
		}else{
			int n=userService.authCode(phone,password,rePassword);
			return n;
		}
	}
	
	/**
	 * 验证用户名
	 */
	@RequestMapping("/checkname.do")
	public JsonResult<Object> checkName(String name){
		Object n=userService.checkName(name);
		return new JsonResult<Object>(n);
	}
	
	/**
	 * 注册验证手机号
	 */
	@RequestMapping("/checkphone.do")
	public JsonResult<Object> checkPhone(String phone){
		Object n=userService.checkPhone(phone);
		return new JsonResult<Object>(n);
	}
	
	/**
	 * 忘记密码的手机验证
	 * @param phone
	 * @return
	 */
	@RequestMapping("/changephone.do")
	public JsonResult<User> changePhone(String phone){
		User user=userService.changePhone(phone);
		return new JsonResult<User>(user);
	}
	
	
	/**
	 * 发送验证码
	 */
	@RequestMapping("/phone.do")
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
						System.out.println(mobile_code);
						//System.out.println("1213223132132");
						return code;
					}
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				return 1;
	}
	
	/**
	 *  注册
	 */
	@RequestMapping("/register.do")
	public JsonResult<User> Register(HttpServletRequest request,String name, String phone, String password, String confirm,int type,String verifyNo){
		HttpSession session = request.getSession(); 
		String object=session.getAttribute(phone).toString();
		if(session==null||session.getAttribute(phone)==null){
			throw new RuntimeException("网络异常");
		}
//		System.out.println("验证码："+object);
//		System.out.println("verifyNo:"+verifyNo);
		if(!verifyNo.equals(object)){
			throw new RuntimeException("验证码不正确");
			//System.out.println("验证码不正确！");
		}else{
			//System.out.println("验证码ok！");
			User user=userService.regist(name, phone, password, confirm, type);
			return new JsonResult<User>(user);
		}
	}
}