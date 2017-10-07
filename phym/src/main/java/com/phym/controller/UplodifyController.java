package com.phym.controller;

import com.alibaba.fastjson.JSON;
import com.phym.entity.OutDoorScreen;
import com.phym.service.OutDoorScreenService;
import com.phym.util.NoteUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@RestController
@RequestMapping("advertiser/upload")
public class  UplodifyController extends BaseController{
	
	  @Autowired
	  private OutDoorScreenService outDooorScreenService;
	  
	  @RequestMapping(value = "/one.do", method = RequestMethod.POST)
	  public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    MultipartHttpServletRequest multipartRequest = 
	    (MultipartHttpServletRequest) request;
	    Iterator<String> fileNames = multipartRequest.getFileNames();
	    MultipartFile multipartFile = multipartRequest.getFile(fileNames.next());
	    //原始名字
	    String name = multipartFile.getOriginalFilename();
	    //文件后缀/格式
	    String fileType = name.split("[.]")[1];
	    //新的文件的名字
	    String  fname = NoteUtil.createId()+"."+fileType;
	    String filePath = request.getSession().getServletContext().getRealPath("/");
	   
	    //获取前端传递的参数id
	    String outDoorId = request.getParameter("outDoorId");
	    List<OutDoorScreen> list = outDooorScreenService.findOutDoorContent(outDoorId);
	    String finalPath = null;
	    for(OutDoorScreen outDoor : list) {
	    	finalPath=saveFile(fname,outDoor,fileType,filePath, multipartFile.getBytes());
	    }
	    
	    Map<String, String> resultMap = new HashMap<String, String>(5);
	    resultMap.put("result", "success");
	    resultMap.put("filePath", finalPath);
	    return JSON.toJSONString(resultMap);
	  }
	
	  //保存文件
	  public String saveFile( String fname,OutDoorScreen outDoor,String fileType,String filePath, byte[] content) throws IOException {
	    BufferedOutputStream bos = null;
	    String fil =null;
	    try {
	    	if(fileType.equals("jpg")||fileType.equals("jpeg")||fileType.equals("png")){
	    		 fil=filePath+"imgs\\"+fname;
	    	}else if(fileType.equals("mp4")){
	    		 fil=filePath+"videos\\"+outDoor.getOutdoorId()+"\\"+fname;
	    	}else if(fileType.equals("txt")) {
	    		fil=filePath+"files\\"+fname;
	    	}else{
	    		throw new RuntimeException("类型不匹配");
	    	}
	    	File file = new File(fil);
			//判断路径是否存在
	    	if (!file.getParentFile().exists()) {
	    		//文件路径不存在时，创建保存文件所需要的路径
		        file.getParentFile().mkdirs();
		      }
	    	//创建文件（这是个空文件，用来写入上传过来的文件的内容）
		      file.createNewFile();
		      bos = new BufferedOutputStream(new FileOutputStream(file));
		      bos.write(content);
		      return fil;
	    } catch (FileNotFoundException e) {
	    	throw new FileNotFoundException("文件不存在。");
	    } finally {
	      if (null != bos) {
	        bos.close();
	      }
	    }
	  }
	}