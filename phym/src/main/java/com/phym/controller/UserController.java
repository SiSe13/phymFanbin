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
	 * �������¼
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
	 * ý������¼
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
	//������������������Ŀ�ı���session������
	public JsonResult<String> heartbeat(){
		//System.out.println("OK"); 
		return new JsonResult<String>("OK");
	}
	
	/**
	 * �޸�����
	 */
	@RequestMapping("/authcode.do")
	public int authCode(HttpServletRequest request,String phone,String verifyNo,String password,String rePassword){
		HttpSession session = request.getSession(); 
		String object=session.getAttribute(phone).toString();
		if(session==null||session.getAttribute(phone)==null){
			throw new RuntimeException("�����쳣");
		}

		if(!verifyNo.equals(object)){
			throw new RuntimeException("��֤�벻��ȷ");
		}else{
			int n=userService.authCode(phone,password,rePassword);
			return n;
		}
	}
	
	/**
	 * ��֤�û���
	 */
	@RequestMapping("/checkname.do")
	public JsonResult<Object> checkName(String name){
		Object n=userService.checkName(name);
		return new JsonResult<Object>(n);
	}
	
	/**
	 * ע����֤�ֻ���
	 */
	@RequestMapping("/checkphone.do")
	public JsonResult<Object> checkPhone(String phone){
		Object n=userService.checkPhone(phone);
		return new JsonResult<Object>(n);
	}
	
	/**
	 * ����������ֻ���֤
	 * @param phone
	 * @return
	 */
	@RequestMapping("/changephone.do")
	public JsonResult<User> changePhone(String phone){
		User user=userService.changePhone(phone);
		return new JsonResult<User>(user);
	}
	
	
	/**
	 * ������֤��
	 */
	@RequestMapping("/phone.do")
	public int sendCode(HttpServletRequest request,String phone){ 
				/*
				 * �����ֻ��Ų�ѯ�û�
				 * �����˵���Ѿ�ע�᷵���쳣
				 * ʡ��
				 */
				HttpClient client = new HttpClient();
				PostMethod method = new PostMethod(Url);
				client.getParams().setContentCharset("UTF-8");
				method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
				
				/*
				 * ������ɵ�6λ��֤��
				 */
				int mobile_code=(int) ((Math.random()*9+1)*100000);
				
				//���Ͷ�������
				String content= new String("������֤����:"+mobile_code+"������ҳ�����ύ��֤�������֤��");
				//��������
				NameValuePair[] data={//�ύ����
						 new NameValuePair("account", "C74683282"), 
						    new NameValuePair("password", "f521ea17f244b4410f29f0ecc96bab18"), //�鿴�������¼�û�����->��֤�롢֪ͨ����->�ʻ���ǩ������->APIKEY
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
						//System.out.println(mobile_code);
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
	 * ע��
	 */
	@RequestMapping("/register.do")
	public JsonResult<User> Register(HttpServletRequest request,String name, String phone, String password, String confirm,int type,String verifyNo){
		HttpSession session = request.getSession(); 
		String object=session.getAttribute(phone).toString();
		if(session==null||session.getAttribute(phone)==null){
			throw new RuntimeException("�����쳣");
		}
//		System.out.println("��֤�룺"+object);
//		System.out.println("verifyNo:"+verifyNo);
		if(!verifyNo.equals(object)){
			throw new RuntimeException("��֤�벻��ȷ");
			//System.out.println("��֤�벻��ȷ��");
		}else{
			//System.out.println("��֤��ok��");
			User user=userService.regist(name, phone, password, confirm, type);
			return new JsonResult<User>(user);
		}
	}
}
