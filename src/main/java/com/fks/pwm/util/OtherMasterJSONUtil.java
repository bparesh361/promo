package com.fks.pwm.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fks.pwm.entity.MstCalender;
import com.fks.pwm.entity.MstCampaign;

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
}
