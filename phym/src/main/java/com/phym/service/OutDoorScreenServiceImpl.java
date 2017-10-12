package com.phym.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.OrderMediaDao;
import com.phym.dao.OutDoorScreenDao;
import com.phym.dao.UserDao;
import com.phym.entity.OrderMedia;
import com.phym.entity.OutDoorScreen;
import com.phym.entity.User;
import com.phym.exception.OutDoorScreenException;
import com.phym.util.NoteUtil;

@Service("outDoorScreenService")
public class OutDoorScreenServiceImpl implements OutDoorScreenService {
	
	@Autowired
	private OutDoorScreenDao outDoorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderMediaDao mediaDao;
	
	//上传媒体资源
	public Boolean uploadResource(OutDoorScreen outDoor) throws OutDoorScreenException{
		if(outDoor == null) {
			return false;
		}
		
		if(outDoor.getOutdoorName()==null) {
			throw new OutDoorScreenException("必填选项");
		}
		String reg1 = "^[一-龥a-zA-Z][一-龥a-zA-Z0-9_]*$";
		if(outDoor.getOutdoorName().length()>=30 || !outDoor.getOutdoorName().matches(reg1)) {
			throw new OutDoorScreenException("3-20位，中文、字母、数字、下划线的组合，以中文或字母开头");
		}
		if(outDoor.getOutdoorProvince()==null) {
			throw new OutDoorScreenException("请选择省");
		}
		if(outDoor.getOutdoorCity()==null) {
			throw new OutDoorScreenException("请选择市");
		}
		if(outDoor.getOutdoorCountry()==null) {
			throw new OutDoorScreenException("请选择区/县");
		}
		if(outDoor.getOutdoorAddress()==null) {
			throw new OutDoorScreenException("请填写大屏地址");
		}
		if(outDoor.getOutdoorAddress().length()>=100) {
			throw new OutDoorScreenException("输入文本过长");
		}
		if(outDoor.getOutdoorMediasourceType()==null) {
			throw new OutDoorScreenException("请选择资源类型");
		}
		if(outDoor.getOutdoorScreenType()==null) {
			throw new OutDoorScreenException("请选择屏幕类型");
		}
		if(outDoor.getOutdoorScreenSize()==null) {
			throw new OutDoorScreenException("请输入内容");
		}
		
		if(outDoor.getOutdoorScreenSize().equals("")) {
			throw new OutDoorScreenException("请输入3-5位有效数字，第一位不能为0");
		}
		
		String reg2 = "^[1-9]\\d{2,9}";
		String str = outDoor.getOutdoorLength();
		String sts = outDoor.getOutdoorHeight();
		if(str.equals("") ||sts.equals("")) {
			throw new OutDoorScreenException("请填写内容");
		}
		
		if(reg2.matches(str) || reg2.matches(sts)) {
			throw new OutDoorScreenException("请输入3-10有效数字，第一位不能为0");
		}
		if(outDoor.getOutdoorPlayStartTime()==null || outDoor.getOutdoorPlayEndTime()==null) {
			throw new OutDoorScreenException("请选择播放时间");
		}
		if(outDoor.getOutdoorSuperiority() == null) {
			throw new OutDoorScreenException("请填写内容");
		}
		if(outDoor.getOutdoorSuperiority().length()>=150) {
			throw new OutDoorScreenException("输入文本过长");
		}
		/*if(outDoor.getOutdoorAptitude()==null) {
			throw new OutDoorScreenException("请选择资质文件");
		}*/
		if(outDoor.getOutdoorRemark()==null) {
			throw new OutDoorScreenException("请填写内容");
		}
		if(outDoor.getOutdoorRemark().length()>=40) {
			throw new OutDoorScreenException("输入文本过长");
		}
		if(outDoor.getOutdoorPlaybackPeriod()==null) {
			throw new OutDoorScreenException("请输入内容");
		}
		String reg3 = "^[1-9]\\d{0,3}";		
		if(reg3.matches(outDoor.getOutdoorPlaybackPeriod())) {
			throw new OutDoorScreenException("请输入1-3位有效数字，第一位不能为0");
		}
		//图片
		if(outDoor.getOutdoorPhotoPath()==null) {
			throw new OutDoorScreenException("请上传照片");
		}
		outDoor.setOutdoorId(NoteUtil.createId());
		String userName = outDoor.getOutdoorUserName();
		User user = userDao.findUserByName(userName);
		String level = user.getUser_level();
		Integer pri = new Integer(level)*1;
		String price = pri.toString();
		outDoor.setOutdoorUnitPrice(price);		
		outDoor.setOutdoorStatus(0);
		outDoor.setOutdoorCheckStatus(0);
		String fre = (Integer.parseInt(outDoor.getOutdoorPlayEndTime())-Integer.parseInt(outDoor.getOutdoorPlayStartTime()))*60/Integer.parseInt(outDoor.getOutdoorPlaybackPeriod())+"";
		outDoor.setOutdoorFrequency(fre);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		outDoor.setOutdoorCreatedDate(time);
		outDoor.setRemainTime(Integer.parseInt(outDoor.getOutdoorPlaybackPeriod())*60);
		int i = outDoorDao.insertOutDoor(outDoor);
		if(i !=1) {
			throw new OutDoorScreenException("上传资源失败");
		}
		return true;
	}

	//媒体主点击户外大屏显示媒体资源
	public List<OutDoorScreen> loadOutDoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,String userId) {
		if(userId ==null || userId.trim().isEmpty()) {
			throw new OutDoorScreenException("错误的ID");
		}
		User user = userService.findUserById(userId);
		if(user ==null) {
			throw new OutDoorScreenException("用户不存在");
		}
		String outdoorUserName = user.getUser_nickname();
		if(outdoorUserName ==null) {
			throw new OutDoorScreenException("用户真的不存在");
		}
		List<OutDoorScreen> list = outDoorDao.loadOutDoor(outdoorProvince, outdoorCity, outdoorCountry, outdoorScreenType, outdoorMediasourceType, outdoorUserName);
		if(list.isEmpty()) {
			throw new OutDoorScreenException("没有本地资源");
		}
		return list;
	}
	
	//删除媒体资源
	public Boolean deleteMediaResource(String outdoorId) {
		if(outdoorId ==null ||outdoorId.trim().isEmpty()) {
			throw new OutDoorScreenException("ID错误");
		}
		int i = outDoorDao.deleteOutDoor(outdoorId);
		if(i!=1) {
			throw new OutDoorScreenException("删除资源失败");
		}
		
		return true;
	}
	//通过id查询媒体资源
	public OutDoorScreen findOutDoorScreenById(String outDoorId) {
		if(outDoorId ==null ||outDoorId.trim().isEmpty()) {
			throw new OutDoorScreenException("ID错误");
		}
		OutDoorScreen outDoor = outDoorDao.findOutDoorScreenById(outDoorId);
		if(outDoor == null) {
			throw new OutDoorScreenException("出错了");
		}
	
		return outDoor;
	}
	
	//修改媒体资源
	public Boolean modifyOutDoor(OutDoorScreen outDoor) throws OutDoorScreenException{
		
		String outdoorId = outDoor.getOutdoorId();
		OutDoorScreen out = outDoorDao.findOutDoorScreenById(outdoorId);
		String outdoorName = outDoor.getOutdoorName();
		String outdoorProvince = outDoor.getOutdoorProvince();
		String outdoorCity = outDoor.getOutdoorCity();
		String outdoorCountry = outDoor.getOutdoorCountry();
		String outdoorAddress = outDoor.getOutdoorAddress();
		String outdoorMediasourceType = outDoor.getOutdoorMediasourceType();
		String outdoorScreenType = outDoor.getOutdoorScreenType();
		String outdoorScreenSize = outDoor.getOutdoorScreenSize();
		String outdoorLength = outDoor.getOutdoorLength();
		String outdoorHeight = outDoor.getOutdoorHeight();
		String outdoorPlayStartTime = outDoor.getOutdoorPlayStartTime();
		String outdoorPlayEndTime = outDoor.getOutdoorPlayEndTime();
		String outdoorPhotoPath = outDoor.getOutdoorPhotoPath();
		String outdoorSuperiority = outDoor.getOutdoorSuperiority();
		String outdoorRemark = outDoor.getOutdoorRemark();
		String outdoorPlaybackPeriod = outDoor.getOutdoorPlaybackPeriod();
		
		if(out.getOutdoorName().equals(outdoorName)) {
			outdoorName = null;
		}
		if(out.getOutdoorProvince().equals(outdoorProvince)) {
			outdoorProvince = null	;
		}
		if(out.getOutdoorCity().equals(outdoorCity)) {
			outdoorCity = null;
		}
		if(out.getOutdoorCountry().equals(outdoorCountry)) {
			outdoorCountry = null	;
		}
		if(out.getOutdoorAddress().equals(outdoorAddress)) {
			outdoorAddress = null;
		}
		if(out.getOutdoorMediasourceType().equals(outdoorMediasourceType)) {
			outdoorMediasourceType = null;
		}
		if(out.getOutdoorScreenType().equals(outdoorScreenType)) {
			
			outdoorScreenType = null;
		}
		if(out.getOutdoorScreenSize().equals(outdoorScreenSize)) {
			outdoorScreenSize= null;
		}
		if(out.getOutdoorLength().equals(outdoorLength)) {
			outdoorLength = null;
		}
		if(out.getOutdoorHeight().equals(outdoorHeight)) {
			outdoorHeight = null;
		}
		if(out.getOutdoorPlayStartTime().equals(outdoorPlayStartTime)) {
			outdoorPlayStartTime = null;
		}
		if(out.getOutdoorPlayEndTime().equals(outdoorPlayEndTime)) {
			outdoorPlayEndTime = null;
		}
		if(out.getOutdoorPhotoPath().equals(outdoorPhotoPath)) {
			outdoorPhotoPath= null;
		}
		if(out.getOutdoorSuperiority().equals(outdoorSuperiority)) {
			outdoorSuperiority = null;
		}
		if(out.getOutdoorRemark().equals(outdoorRemark)) {
			outdoorRemark = null;
		}
		if(out.getOutdoorPlaybackPeriod().equals(outdoorPlaybackPeriod)) {
			outdoorPlaybackPeriod = null;
		}
		
		outDoor.setOutdoorModifyDate(new Timestamp(System.currentTimeMillis()));
		int n = outDoorDao.modifyOutDoor(outDoor);
		if(n != 1) {
			throw new OutDoorScreenException("修改资源失败");
		}
		return true;
	}
	
	//点击户外大屏加载审核通过的所有资源
	public List<OutDoorScreen> findOutDoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,int pager) throws OutDoorScreenException {
		if(pager<0) {
			throw new OutDoorScreenException("错误");
		}
		List<OutDoorScreen> list=outDoorDao.findOutDoor(outdoorProvince, outdoorCity, outdoorCountry, outdoorScreenType, outdoorMediasourceType, pager);
		if(list==null){
			throw new OutDoorScreenException("无内容");
		}
		return list;
	}
	//加入购物车
	public List<OutDoorScreen> findOutDoorContent(String outDoorId) throws OutDoorScreenException {
		
		if(outDoorId ==null) {
			throw new OutDoorScreenException("还没有加入购物车");
		}
		List<String> lisr =new ArrayList<String>();
		String[] arr= outDoorId.split(","); 
		for(int i=0;i<arr.length;i++){
			lisr.add(arr[i]);
		}
		List<OutDoorScreen> list= outDoorDao.findOutDoorContent(lisr);
		return list;
		
	}
	//查询大屏数据总数
	public int sumOutDoor(OutDoorScreen outDoor) throws OutDoorScreenException {
		int count = outDoorDao.sumOutDoor(outDoor);
		
		return count;
	}
	//审核
	public Boolean auditOutDoor(OutDoorScreen outDoor) throws OutDoorScreenException {
		if(outDoor ==null) {
			throw new OutDoorScreenException("未接收到数据");
		}
		
		if(outDoor.getOutdoorId() ==null) {
			throw new OutDoorScreenException("无效的ID");
		}
		
		if(outDoor.getOutdoorCheckStatus() ==0) {
			throw new OutDoorScreenException("请审核");
		}
		if(outDoor.getAuditName()==null) {
			throw new OutDoorScreenException("请输入审核人");
		}
		outDoor.setAuditDate(new Timestamp(System.currentTimeMillis()));
		int num = outDoorDao.auditOutDoor(outDoor);
		if(num !=1) {
			throw new OutDoorScreenException("审核失败");
		}
		return true;
	}

	//开始订单筛选
	public List<OutDoorScreen> filtrateScreen(String outdoorProvince, String outdoorCity, String outdoorCountry, String checkshipin,
			String shichang, String outdoorScreenType, String outdoorMediasourceType, int pager) throws OutDoorScreenException {
		
		String reg="^[0-9]*$";
		
		if(checkshipin==null|| !checkshipin.matches(reg)) {
			throw new OutDoorScreenException("请输入视频时长");
		}
		if( shichang==null||!shichang.matches(reg)) {
			throw new OutDoorScreenException("请输入播放时长");
		}
		int SC = Integer.parseInt(shichang);
		
		if(pager<0) {
			throw new OutDoorScreenException("出错了");
		}
		List<OutDoorScreen> list = outDoorDao.findOutDoor(outdoorProvince, outdoorCity, outdoorCountry, outdoorScreenType, outdoorMediasourceType, pager);
		
		if(list==null) {
			throw new OutDoorScreenException("未搜索到内容");
		}
		List<OutDoorScreen> lis = new ArrayList<OutDoorScreen>();
		
		for(OutDoorScreen out : list) {
			if(out.getRemainTime()>SC) {
				lis.add(out);
			}
		}
		return lis;
	}
	
	//通过媒体主id查询订单
	public List<OrderMedia> findOrderFormByUserId(String userId) {
		if(userId ==null || userId.trim().isEmpty()) {
			throw new OutDoorScreenException("错误的ID");
		}
		User user = userService.findUserById(userId);
		if(user ==null) {
			throw new OutDoorScreenException("用户不存在");
		}
		String userName = user.getUser_nickname();
		List<OutDoorScreen> list = outDoorDao.findOutDoorScreenByUserName(userName);
		if(list.isEmpty()) {
			throw new OutDoorScreenException("您还没有上传资源");
		}
		List<String> llt = new ArrayList<String>();
		for(OutDoorScreen outDoor : list) {
			llt.add(outDoor.getOutdoorId());
		}
		if(llt.isEmpty()) {
			throw new OutDoorScreenException("未获取到大屏ID");
		}
		List<OrderMedia> list1 = new ArrayList<OrderMedia>();
		List<OrderMedia> list2 = mediaDao.findAllOrderMedia();
		
		if(list2.isEmpty()) {
			throw new OutDoorScreenException("没有订单");
		}
		for(OrderMedia media : list2) {
			if(llt.contains(media.getMediaId())) {
				list1.add(media);
			}
		}
		return list1;
	}

		
}
