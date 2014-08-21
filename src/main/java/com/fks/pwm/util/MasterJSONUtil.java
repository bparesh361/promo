package com.fks.pwm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstLeadTime;
import com.fks.pwm.entity.MstStatus;
import com.fks.pwm.entity.MstStore;

public class MasterJSONUtil {

	public static JSONObject getJsonForLeadTimeStatus(List<MstStatus> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstStatus vo : list) {
				cellobj.put(WebConstants.ID, vo.getStatusId());
				cell.add(vo.getStatusId());
				cell.add(vo.getStatusDesc());
				cell.add(vo.getL1());
				cell.add(vo.getL2());
				cell.add(vo.getL5());
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

	public static JSONObject getJsonLeadTimeForPromoSetUp(
		MstLeadTime mstLeadTime) {
		JSONObject responsedata = new JSONObject();
		responsedata.put(WebConstants.PROMO_LEAD_TIME_VALUE,mstLeadTime.getValue());
		return responsedata;
	}
	
	public static JSONObject getJsonForMCH(List<Mch> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		int counter = 0;
		if (list != null) {
			for (Mch vo : list) {
				cellobj.put(WebConstants.ID, counter++);
				cell.add(vo.getCategoryName());
				cell.add(vo.getSubCategoryName());
				cell.add(vo.getMcCode());
				cell.add(vo.getMcName());
				cell.add(vo.getMstLocation().getLocationName());
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
	
	public static JSONObject getJsonForSiteSelectionUserPage(MstStore store){
		JSONObject responsedata = new JSONObject();
		JSONArray array = new JSONArray();
		Map<String,String> map = new HashMap<String,String>();
		map.put(store.getMstStoreId(), store.getMstStoreId()+ " : "+store.getSiteDescription());		
		responsedata.putAll(map);
		return responsedata;

	}

}
