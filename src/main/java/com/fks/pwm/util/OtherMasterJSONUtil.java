package com.fks.pwm.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fks.pwm.entity.MstCalender;
import com.fks.pwm.entity.MstCampaign;
import com.fks.pwm.entity.MstDepartment;
import com.fks.pwm.entity.MstMktg;
import com.fks.pwm.entity.MstProblem;
import com.fks.pwm.entity.MstPromotionType;
import com.fks.pwm.entity.MstReasonRejection;
import com.fks.pwm.entity.MstReportEmail;
import com.fks.pwm.entity.MstTask;
import com.fks.pwm.entity.MstZone;

public class OtherMasterJSONUtil {

	public static JSONObject getJsonForLeadTimeStatus(List<MstCampaign> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstCampaign vo : list) {
				cellobj.put(WebConstants.ID, vo.getCampaignId());
				cell.add(vo.getCampaignId());
				cell.add(vo.getCampaignName());
				if(vo.getIsActive()==0)
					cell.add(WebConstants.ACTIVE_STR);
				else
					cell.add(WebConstants.BLOCKED_STR);				
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	
	public static JSONObject getJsonForReportEmail(List<MstReportEmail> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstReportEmail vo : list) {
				cellobj.put(WebConstants.ID, vo.getMstReportTypeEmailId());
				cell.add(vo.getMstReportTypeEmailId());
				cell.add(vo.getEmailId());
				cell.add(vo.getMstZoneName());								
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	public static JSONObject getJsonForCalendar(List<MstCalender> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstCalender vo : list) {
				cellobj.put(WebConstants.ID, vo.getMstCalenderId());
				cell.add(vo.getMstCalenderId());
				cell.add(CommonUtil.getDateStr(vo.getCalDate()));
				cell.add(vo.getDateDescription());
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	public static JSONObject getJsonForZone(List<MstZone> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstZone vo : list) {
				cellobj.put(WebConstants.ID, vo.getZoneId());
				cell.add(vo.getZoneId());
				cell.add(vo.getZoneName());
				cell.add(vo.getZoneCode());
				if(vo.getIsBlocked()==0)
					cell.add(WebConstants.ACTIVE_STR);
				else
					cell.add(WebConstants.BLOCKED_STR);	
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	
	public static JSONObject getJsonForProblem(List<MstProblem> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstProblem vo : list) {
				cellobj.put(WebConstants.ID, vo.getProblemTypeId());
				cell.add(vo.getProblemTypeId());
				cell.add(vo.getProblemName());
				if(vo.getIsBlocked()==0)
					cell.add(WebConstants.ACTIVE_STR);
				else
					cell.add(WebConstants.BLOCKED_STR);	
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	
	public static JSONObject getJsonObjectForDepartment(List<MstDepartment> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstDepartment vo : list) {
				cellobj.put(WebConstants.ID, vo.getMstDeptId());
				cell.add(vo.getMstDeptId());
				cell.add(vo.getDeptName());
				if(vo.getIsBlocked()==0)
					cell.add(WebConstants.ACTIVE_STR);
				else
					cell.add(WebConstants.BLOCKED_STR);	
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	
	public static JSONObject getJsonForTask(List<MstTask> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstTask vo : list) {
				cellobj.put(WebConstants.ID, vo.getTaskId());
				cell.add(vo.getTaskId());
				cell.add(vo.getTaskName());
				if(vo.getIsBlocked()==0)
					cell.add(WebConstants.ACTIVE_STR);
				else
					cell.add(WebConstants.BLOCKED_STR);	
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	
	public static JSONObject getJsonForReason(List<MstReasonRejection> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstReasonRejection vo : list) {
				cellobj.put(WebConstants.ID, vo.getReasonRejectionId());
				cell.add(vo.getReasonRejectionId());
				cell.add(vo.getReasonName());
				if(vo.getIsBlocked()==0)
					cell.add(WebConstants.ACTIVE_STR);
				else
					cell.add(WebConstants.BLOCKED_STR);	
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	public static JSONObject getJsonForMarketing(List<MstMktg> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstMktg vo : list) {
				cellobj.put(WebConstants.ID, vo.getMktgId());
				cell.add(vo.getMktgId());
				cell.add(vo.getMktgName());
				if(vo.getIsBlocked()==0)
				cell.add("Active");
				else
					cell.add("Blocked");
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
	
	public static JSONObject getJsonForPromotion(List<MstPromotionType> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstPromotionType vo : list) {
				cellobj.put(WebConstants.ID, vo.getPromoTypeId());
				cell.add(vo.getPromoTypeId());
				cell.add(vo.getPromoTypeName());
				if(vo.getIsBlocked()==0)
				cell.add("Active");
				else
					cell.add("Blocked");
				cellobj.put(WebConstants.CELL, cell);
				cell.clear();
				cellarray.add(cellobj);

			}
			responsedata.put(WebConstants.PAGE, "1");
			responsedata.put(WebConstants.RECORDS, list.size());
			responsedata.put(WebConstants.ROWS, cellarray);

		}
		return responsedata;
	}
}
