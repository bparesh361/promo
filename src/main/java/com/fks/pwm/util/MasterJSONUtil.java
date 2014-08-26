package com.fks.pwm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fks.pwm.entity.MapModuleProfile;
import com.fks.pwm.entity.MapRoleProfile;
import com.fks.pwm.entity.MapUserDepartment;
import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstLeadTime;
import com.fks.pwm.entity.MstLocation;
import com.fks.pwm.entity.MstModule;
import com.fks.pwm.entity.MstProfile;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.entity.MstStatus;
import com.fks.pwm.entity.MstStore;
import com.fks.pwm.entity.MstZone;

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

	public static JSONObject getJsonForRolePage(List<MstRole> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstRole vo : list) {
				cellobj.put(WebConstants.ID, vo.getMstRoleId());
				cell.add(vo.getMstRoleId());
				cell.add(vo.getRoleName());
				if (vo.getIsActive() == 0) {
					cell.add("Active");
				} else {
					cell.add("Blocked");
				}
				if (vo.getCreatedDate() == null) {
					cell.add("-");
				} else {
					cell.add(CommonUtil.getDateStr(vo.getCreatedDate()));
				}

				if (vo.getMstEmployee1() == null) {
					cell.add("-");
				} else {
					cell.add(vo.getMstEmployee1().getEmployeeName());
				}
				if (vo.getMstEmployee2() == null) {
					cell.add("-");
				} else {
					cell.add(vo.getMstEmployee2().getEmployeeName());
				}
				if (vo.getUpdatedDate() == null) {
					cell.add("-");
				} else {
					cell.add(CommonUtil.getDateStr(vo.getUpdatedDate()));
				}
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

	public static JSONObject getJsonForProfilePage(List<MstProfile> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		if (list != null) {
			for (MstProfile vo : list) {
				cellobj.put(WebConstants.ID, vo.getProfileId());
				cell.add(vo.getProfileId());
				cell.add(vo.getProfileName());
				cell.add(vo.getLevelAccess());
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

	public static JSONObject getJsonForProfileDropDown(List<MstProfile> list) {
		JSONObject responsedata = new JSONObject();
		if (list != null) {
			for (MstProfile vo : list) {
				responsedata.put(vo.getProfileId(), vo.getProfileName());
			}
		}
		return responsedata;
	}

	public static JSONObject getJsonLeadTimeForPromoSetUp(
			MstLeadTime mstLeadTime) {
		JSONObject responsedata = new JSONObject();
		responsedata.put(WebConstants.PROMO_LEAD_TIME_VALUE,
				mstLeadTime.getValue());
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

	public static JSONObject getJsonForSiteSelectionUserPage(
			List<MstStore> stores) {
		JSONObject responsedata = new JSONObject();
		Map<String, String> map = new HashMap<String, String>();
		for (MstStore store : stores) {
			map.put(store.getMstStoreId(), store.getMstStoreId() + " : "
					+ store.getSiteDescription());
		}
		responsedata.putAll(map);
		return responsedata;
	}

	public static JSONObject getJsonForRoles(List<MstRole> roles) {
		JSONObject responsedata = new JSONObject();
		Map<Long, String> map = new HashMap<Long, String>();
		for (MstRole role : roles) {
			map.put(role.getMstRoleId(), role.getRoleName());
		}
		responsedata.putAll(map);
		return responsedata;
	}

	public static JSONObject getJsonForLocations(List<MstLocation> locations) {
		JSONObject responsedata = new JSONObject();
		Map<Long, String> map = new HashMap<Long, String>();
		for (MstLocation location : locations) {
			map.put(location.getLocationId(), location.getLocationName());
		}
		responsedata.putAll(map);
		return responsedata;
	}

	public static JSONObject getJsonForZones(List<MstZone> zones) {
		JSONObject responsedata = new JSONObject();
		Map<Long, String> map = new HashMap<Long, String>();
		for (MstZone zone : zones) {
			map.put(zone.getZoneId(), zone.getZoneName());
		}
		responsedata.putAll(map);
		return responsedata;
	}

	public static JSONObject getJsonForSiteDescription(MstStore store) {
		JSONObject responsedata = new JSONObject();
		responsedata.put("desc", store.getSiteDescription());
		responsedata.put("format", store.getFormatName());
		responsedata.put("region", store.getRegionName());
		responsedata.put("location", store.getMstLocation().getLocationName());
		responsedata.put("city", store.getCity());
		responsedata.put("zone", store.getMstZone().getZoneName());
		return responsedata;
	}

	public static JSONObject getJsonForEmployeeFlexBox(
			List<MstEmployee> employees) {
		JSONObject responsedata = new JSONObject();
		JSONArray array = new JSONArray();
		for (MstEmployee emp : employees) {
			JSONObject cell = new JSONObject();
			cell.put("id", emp.getEmpId());
			cell.put("name", emp.getEmployeeName());
			array.add(cell);
		}
		responsedata.put("results", array);
		return responsedata;
	}

	public static JSONObject getJsonForRoleFlexBox(List<MstRole> roles) {
		JSONObject responsedata = new JSONObject();
		JSONArray array = new JSONArray();
		for (MstRole role : roles) {
			JSONObject cell = new JSONObject();
			cell.put("id", role.getMstRoleId());
			cell.put("name", role.getRoleName());
			array.add(cell);
		}
		responsedata.put("results", array);
		return responsedata;
	}

	public static JSONObject getJsonForProfilePageRoleFlexBox(MstRole role) {
		JSONObject responsedata = new JSONObject();
		if (role.getMapRoleLocations() != null
				&& role.getMapRoleLocations().size() == 1) {
			responsedata.put("location", role.getMapRoleLocations().get(0)
					.getMstLocation().getLocationId());
		} else {
			responsedata.put("location", "-1");
		}
		JSONArray array = new JSONArray();
		for (MapRoleProfile roleProfile : role.getMapRoleProfiles()) {
			array.add(roleProfile.getMstProfile().getProfileId());
		}
		JSONObject o = new JSONObject();
		o.put("profileIdList", array);
		responsedata.put("rows", o);
		return responsedata;
	}

	public static JSONObject getJsonForStoreFlexBox(List<MstStore> stores) {
		JSONObject responsedata = new JSONObject();
		JSONArray array = new JSONArray();
		for (MstStore store : stores) {
			JSONObject cell = new JSONObject();
			cell.put("id", store.getMstStoreId());
			cell.put("name", store.getSiteDescription());
			array.add(cell);
		}
		responsedata.put("results", array);
		return responsedata;
	}

	public static JSONObject getJsonForEmployeeToUpdateById(MstEmployee emp) {
		JSONObject responsedata = new JSONObject();
		if (emp != null) {
			JSONObject cell = new JSONObject();
			cell.put("empCode", emp.getEmpId());
			cell.put("srtEmpName", emp.getEmployeeName());
			cell.put("strContactNo", emp.getContactNo());
			cell.put("strReportingTo", emp.getReportingPersonName());
			cell.put("strLocationId", emp.getMstStore().getMstLocation()
					.getLocationId());
			cell.put("strEmail", emp.getEmailId());
			cell.put("strStoreId", emp.getMstStore().getMstStoreId());
			cell.put("pwd", emp.getEmpPassword());
			responsedata.put("rows", cell);
		}
		return responsedata;
	}

	public static JSONObject getJSONGridDataForEmpSearch(List<MstEmployee> list) {
		JSONObject responsedata = new JSONObject();
		JSONArray cellarray = new JSONArray();
		JSONArray cell = new JSONArray();
		JSONObject cellobj = new JSONObject();
		for (MstEmployee emp : list) {
			cellobj.put(WebConstants.ID, emp.getEmpId());
			cell.add(emp.getEmpId());
			cell.add(emp.getEmpCode());
			cell.add(emp.getEmployeeName());
			cell.add(emp.getMstStore().getFormatName());
			cell.add(emp.getContactNo());
			cell.add(emp.getEmailId());
			cell.add(emp.getMstStore().getMstStoreId());
			cell.add(emp.getMstStore().getCity());
			cell.add(emp.getMstStore().getRegionName());
			cell.add(emp.getMstStore().getMstZone().getZoneName());
			cell.add(emp.getMstStore().getMstLocation().getLocationName());
			if (emp.getMapUserDepartments() == null
					|| emp.getMapUserDepartments().size() == 0) {
				cell.add("-");
			} else {
				StringBuffer dept = new StringBuffer("");
				List<MapUserDepartment> mapUserDepartments = emp
						.getMapUserDepartments();
				for (MapUserDepartment map : mapUserDepartments) {
					dept.append(map.getMstDepartment().getDeptName() + ",");
				}
			}

			cell.add(emp.getReportingPersonName());
			cell.add(emp.getTaskManager());
			cell.add(emp.getMstRole().getRoleName());

			if (emp.getIsBlocked() == 0) {
				cell.add("Active");
			} else {
				cell.add("Blocked");
			}
			cell.add("-");
			cell.add("-");
			cell.add("-");
			cell.add("-");

			cellobj.put(WebConstants.CELL, cell);
			cell.clear();
			cellarray.add(cellobj);
		}

		responsedata.put(WebConstants.TOTAL, 10);
		responsedata.put(WebConstants.PAGE, 1);
		responsedata.put(WebConstants.RECORDS, 20);
		responsedata.put(WebConstants.ROWS, cellarray);
		return responsedata;
	}

	public static JSONObject getModuleJson(List<MstModule> list) {
		JSONObject responseData = new JSONObject();
		JSONObject cellObject = new JSONObject();

		List<String> cellmoduleIdArray = new ArrayList<String>();
		List<String> cellmodulenameArray = new ArrayList<String>();
		for (MstModule vo : list) {
			cellmoduleIdArray.add(vo.getModuleId().toString());
			cellmodulenameArray.add(vo.getModuleDesc());
		}
		cellObject.put("moduleIdList", cellmoduleIdArray);
		cellObject.put("moduleNameList", cellmodulenameArray);
		responseData.put("rows", cellObject);
		return responseData;
	}

	public static JSONObject getMapModuleProfile(List<MapModuleProfile> list) {

		JSONObject responseData = new JSONObject();
		JSONObject cellObject = new JSONObject();
		List<String> cellmoduledecArray = new ArrayList<String>();
		List<String> cellmoduleIdArray = new ArrayList<String>();
		for (MapModuleProfile c : list) {
			cellmoduleIdArray.add(c.getMstModule().getModuleId().toString());
			cellmoduledecArray.add(String.valueOf(c.getMstModule()
					.getModuleDesc()));
		}
		cellObject.put("moduledecList", cellmoduledecArray);
		cellObject.put("moduleIdList", cellmoduleIdArray);
		responseData.put("rows", cellObject);
		return responseData;
	}
}
