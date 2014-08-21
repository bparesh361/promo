package com.fks.pwm.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.vo.MchVO;

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

}
