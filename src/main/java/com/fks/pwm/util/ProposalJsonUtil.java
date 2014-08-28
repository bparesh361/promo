package com.fks.pwm.util;

import java.util.List;

import net.sf.json.JSONObject;

import com.fks.pwm.entity.MstDepartment;
import com.fks.pwm.entity.MstProblem;
import com.fks.pwm.entity.MstPromotionType;

public class ProposalJsonUtil {
	
	public static JSONObject getJsonForDepartment(List<MstDepartment> list) {
		JSONObject responsedata = new JSONObject();
		if (list != null) {
			for (MstDepartment vo : list) {
				responsedata.put(vo.getMstDeptId(), vo.getDeptName());
			}
		}
		return responsedata;
	}
	
	public static JSONObject getJsonForProblem(List<MstProblem> list) {
		JSONObject responsedata = new JSONObject();
		if (list != null) {
			for (MstProblem vo : list) {
				responsedata.put(vo.getProblemTypeId(), vo.getProblemName());
			}
		}
		return responsedata;
	}
	
	public static JSONObject getJsonForPromotionType(List<MstPromotionType> list) {
		JSONObject responsedata = new JSONObject();
		if (list != null) {
			for (MstPromotionType vo : list) {
				responsedata.put(vo.getPromoTypeId(), vo.getPromoTypeName());
			}
		}
		return responsedata;
	}
	
}
