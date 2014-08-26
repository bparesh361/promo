package com.fks.pwm.util;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.fks.pwm.entity.Map_user_MCH_F1;
import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.entity.MstStore;
import com.fks.pwm.vo.MchVO;
import com.fks.pwm.vo.UserVO;

public class CommonUtil {

	private static final Logger logger = Logger.getLogger(CommonUtil.class);
	private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public static MchVO getMCHFromCSVLine(String[] line, MstEmployee emp) {
		if (line == null || line.length != 5) {
			logger.info(" --- MCH File Line --- " + line + " Not Correct");
			return null;
		}
		MchVO mch = new MchVO();
		mch.setCategoryName(line[0].trim());
		mch.setSubCategoryName(line[1].trim());
		mch.setMcCode(line[2].trim());
		mch.setMcName(line[3].trim());
		mch.setLocation(line[4].trim());
		return mch;
	}

	public static Mch getMCH(MchVO vo, MstEmployee emp) {
		Mch mch = new Mch();
		mch.setCategoryName(vo.getCategoryName());
		mch.setSubCategoryName(vo.getSubCategoryName());
		mch.setMcName(vo.getMcName());
		mch.setMcCode(vo.getMcCode());
		mch.setMstEmployee(emp);
		return mch;
	}

	public static List<String[]> getMCHList(List<Mch> list) {
		List<String[]> listStr = new ArrayList<String[]>();
		for (Mch mch : list) {
			String[] str = new String[5];
			str[0] = mch.getCategoryName();
			str[1] = mch.getSubCategoryName();
			str[2] = mch.getMcCode();
			str[3] = mch.getMcName();
			str[4] = mch.getMstLocation().getLocationName();
			listStr.add(str);
		}
		return listStr;
	}
	
	public static String getDateStr(Date date){
		if(date==null){
			throw new IllegalArgumentException("Calendar Date Can not be NULL");
		}
		return format.format(date);
	}
	
	public static MstEmployee getEmployeeFromVO(UserVO vo, MstRole role, MstStore store, MstEmployee emp){
		if(emp==null){
			emp = new MstEmployee();
		}
		emp.setEmpId(Long.parseLong(vo.getEmpCode()));
		emp.setUserId(vo.getEmpCode());
		emp.setContactNo(new BigInteger(vo.getEmpContact()));
		emp.setEmpCode(new BigInteger(vo.getEmpCode()));
		emp.setEmployeeName(vo.getEmpName());
		emp.setEmailId(vo.getEmpEmail());
		emp.setReportingPersonName(vo.getEmpMgr());
		emp.setIsBlocked(WebConstants.FALSE_BYTE);
		emp.setMstRole(role);
		emp.setIsPasswordChange(WebConstants.FALSE_BYTE);
		emp.setEmpPassword(WebConstants.DEFAULT_PASSWORD);
		emp.setMstStore(store);
		emp.setStoreDesc(store.getSiteDescription());
		return emp;
	}
	
	public static List<String[]> writeEmployeeData(List<MstEmployee> list) throws Exception {
		List<String[]> emplist = new ArrayList<String[]>();		
		for(MstEmployee emp : list) {
			String[] empStrArray = new String[12]; 
			empStrArray[0] = emp.getEmpId().toString();
			empStrArray[1] = emp.getEmployeeName();
			empStrArray[2] = emp.getMstStore().getFormatName();
			empStrArray[3] = emp.getContactNo().toString();
			empStrArray[4] = emp.getEmailId();
			empStrArray[5] = emp.getMstStore().getSiteDescription();
			empStrArray[6] = emp.getMstStore().getCity();
			empStrArray[7] = emp.getMstStore().getRegionName();
			empStrArray[8] = emp.getMstStore().getMstZone().getZoneName();
			empStrArray[9] = emp.getMstStore().getMstLocation().getLocationName();
			empStrArray[10] = emp.getMstStore().getMstLocation().getLocationName();
			empStrArray[11] = emp.getMstRole().getRoleName();		
			emplist.add(empStrArray);
		}
		return emplist;
	}

	public static List<String> getMCCodeList(List<String[]> list){
		list.remove(0);
		List<String> mcCodeList = new ArrayList<String>();
		for(String[] str : list){
			mcCodeList.add(str[0]);
		}
		return mcCodeList;
	}
	
	
	
}
