package com.phym.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.OutDoorScreenDao;
import com.phym.dao.UserDao;
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
		String reg4 = "^[1-9]\\d{2,4}";
		if(outDoor.getOutdoorScreenSize().matches(reg4)) {
			throw new OutDoorScreenException("请输入3-5位有效数字，第一位不能为0");
		}
		
		String reg2 = "^[1-9]\\d{2,9}";
		String str = outDoor.getOutdoorLength();
		String sts = outDoor.getOutdoorHeight();
		if(str.equals("") ||sts.equals("")) {
			throw new OutDoorScreenException("请填写内容");
		}
		
		if(str.matches(reg2) || sts.matches(reg2)) {
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
		if(outDoor.getOutdoorAptitude()==null) {
			throw new OutDoorScreenException("请选择资质文件");
		}
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
		if(outDoor.getOutdoorPlaybackPeriod().matches(reg3)) {
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
		Timestamp time = new Timestamp(System.currentTimeMillis());
		outDoor.setOutdoorCreatedDate(time);
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
				throw new OutDoorScreenException("您还没有上传资源");
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
		String outDoorId = outDoor.getOutdoorId();
		OutDoorScreen out = outDoorDao.findOutDoorScreenById(outDoorId);
		String outDoorName = outDoor.getOutdoorName();
		String province = outDoor.getOutdoorProvince();
		String city = outDoor.getOutdoorCity();
		String country = outDoor.getOutdoorCountry();
		String address = outDoor.getOutdoorAddress();
		String mediasourceType = outDoor.getOutdoorMediasourceType();
		String screenType = outDoor.getOutdoorScreenType();
		String screenSize = outDoor.getOutdoorScreenSize();
		String length = outDoor.getOutdoorLength();
		String height = outDoor.getOutdoorHeight();
		String startime = outDoor.getOutdoorPlayStartTime();
		String endtime = outDoor.getOutdoorPlayEndTime();
		String photo = outDoor.getOutdoorPhotoPath();
		String superiority = outDoor.getOutdoorSuperiority();
		String aptitude = outDoor.getOutdoorAptitude();
		String remark = outDoor.getOutdoorRemark();
		String playback = outDoor.getOutdoorPlaybackPeriod();
		
		if(out.getOutdoorName().equals(outDoorName)) {
			outDoorName = null;
		}
		if(out.getOutdoorProvince().equals(province)) {
			province = null	;
		}
		if(out.getOutdoorCity().equals(city)) {
			city = null;
		}
		if(out.getOutdoorCountry().equals(country)) {
			country = null	;
		}
		if(out.getOutdoorAddress().equals(address)) {
			address = null;
		}
		if(out.getOutdoorMediasourceType().equals(mediasourceType)) {
			mediasourceType = null;
		}
		if(out.getOutdoorScreenType().equals(screenType)) {
			screenType = null;
		}
		if(out.getOutdoorScreenSize().equals(screenSize)) {
			screenSize= null;
		}
		if(out.getOutdoorLength().equals(length)) {
			length = null;
		}
		if(out.getOutdoorHeight().equals(height)) {
			height = null;
		}
		if(out.getOutdoorPlayStartTime().equals(startime)) {
			startime = null;
		}
		if(out.getOutdoorPlayEndTime().equals(endtime)) {
			endtime = null;
		}
		if(out.getOutdoorPhotoPath().equals(photo)) {
			photo= null;
		}
		if(out.getOutdoorSuperiority().equals(superiority)) {
			superiority = null;
		}
		if(out.getOutdoorAptitude().equals(aptitude)) {
			aptitude = null;
		}
		if(out.getOutdoorRemark().equals(remark)) {
			remark = null;
		}
		if(out.getOutdoorPlaybackPeriod().equals(playback)) {
			playback = null;
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
}
