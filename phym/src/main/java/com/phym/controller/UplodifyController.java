package com.phym.controller;
import com.alibaba.fastjson.JSON;
import com.phym.util.Md5Util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传的Controller
 */
@RestController
@RequestMapping("upload")
public class  UplodifyController extends BaseController{

  @PostMapping("/one.do")
  public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    Iterator<String> fileNames = multipartRequest.getFileNames();
    MultipartFile multipartFile = multipartRequest.getFile(fileNames.next());
    
    //获得文件原始名称
    String name = multipartFile.getOriginalFilename();
    String fileType = name.split("[.]")[1];
    
    //新的文件的名字
    String fname =Md5Util.createId()+"."+fileType;

    String filePath = request.getSession().getServletContext().getRealPath("/");
    String finalPath=saveFile(filePath, fileType,fname,multipartFile.getBytes());
    System.out.println("finalPath:"+finalPath);
    Map<String, String> resultMap = new HashMap<String, String>(5);
    resultMap.put("result", "success");
    resultMap.put("filePath", finalPath);
    return JSON.toJSONString(resultMap);
  }

  //保存文件的方法
  public String saveFile(String filePath,String fileType,String fname , byte[] content) throws IOException {
    BufferedOutputStream bos = null;
    //路径
    String fil=null;
    try {
		if(fileType.equals("jpg")||fileType.equals("jpeg")||fileType.equals("png")){
   		 fil=filePath+"imgs\\"+fname;
	   	}else if(fileType.equals("mp4")){
	   		 fil=filePath+"videos\\"+fname;
	   	}else if(fileType.equals("txt")){
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