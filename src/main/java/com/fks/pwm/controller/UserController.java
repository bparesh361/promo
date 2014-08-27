package com.fks.pwm.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.fks.pwm.entity.Map_user_MCH_F1;
import com.fks.pwm.entity.Map_user_MCH_F2;
import com.fks.pwm.entity.Map_user_MCH_F3;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstLocation;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.entity.MstStore;
import com.fks.pwm.entity.MstZone;
import com.fks.pwm.service.MasterService;
import com.fks.pwm.util.CommonUtil;
import com.fks.pwm.util.MasterJSONUtil;
import com.fks.pwm.util.WebConstants;
import com.fks.pwm.vo.MchVO;
import com.fks.pwm.vo.UserVO;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private MasterService service;

	@RequestMapping("showUserPage")
	public String showUserPage() {
		return "master/user";
	}

	@Value("${download_dir}")
	private String dir;

	@RequestMapping("showStores")
	public void getOrgDetailsByStoreType(@RequestParam Long storeType,
			HttpServletResponse response) throws Exception {
		List<MstStore> stores;
		if (storeType == 1) {
			stores = service.getSites(WebConstants.HO);
		} else if (storeType == 2) {
			stores = service.getSites(WebConstants.STORE);
		} else {
			stores = service.getSites(WebConstants.ZONE);
		}
		JSONObject object = MasterJSONUtil
				.getJsonForSiteSelectionUserPage(stores);
		response.getWriter().print(object);
	}

	@RequestMapping("showRoles")
	public void showRoles(HttpServletResponse response) throws Exception {
		List<MstRole> list = service.findAllRoles();
		JSONObject object = MasterJSONUtil.getJsonForRoles(list);
		response.getWriter().print(object);

	}

	@RequestMapping("showLocations")
	public void showLocations(HttpServletResponse response) throws Exception {
		List<MstLocation> list = service.findAllLocations();
		JSONObject object = MasterJSONUtil.getJsonForLocations(list);
		response.getWriter().print(object);
	}

	@RequestMapping("showZones")
	public void showZones(HttpServletResponse response) throws Exception {
		List<MstZone> list = service.findAllZones();
		JSONObject object = MasterJSONUtil.getJsonForZones(list);
		response.getWriter().print(object);
	}

	@RequestMapping("storeDesc")
	public void getStoreDesc(@RequestParam String storeCode,
			HttpServletResponse repsonse) throws Exception {
		MstStore store = service.getStore(storeCode);
		repsonse.getWriter().print(
				MasterJSONUtil.getJsonForSiteDescription(store));
	}

	@RequestMapping("createuser")
	public String createUser(@ModelAttribute UserVO vo,
			HttpServletRequest request) {
		MstRole role = service.getRole(vo.getRole());
		MstStore store = getStore(vo);
		MstEmployee emp = service.searchEmployeeById(Long.parseLong(vo
				.getEmpCode()));
		if (emp == null) {
			emp = CommonUtil.getEmployeeFromVO(vo, role, store, null);
			service.createEmployee(emp);
		} else {
			service.updateEmployee(vo, role, store);
		}

		request.setAttribute("msg", "User Created / Updated Successfully.");
		return "master/user";
	}

	private MstStore getStore(UserVO vo) {
		String storeCode;
		if (vo.getSiteType().equals("zone")) {
			storeCode = vo.getZoneSelect();
		} else if (vo.getSiteType().equals("store")) {
			storeCode = vo.getStoreSelect();
		} else {
			storeCode = vo.getHoSelect();
		}
		return service.getStore(storeCode);
	}

	@RequestMapping("getEmployeeForFlexBox")
	public void getEmployee(@RequestParam String txtuserempName,
			HttpServletResponse repsonse) throws Exception {
		List<MstEmployee> list = service.searchEmployeeByName(txtuserempName);
		repsonse.getWriter().print(
				MasterJSONUtil.getJsonForEmployeeFlexBox(list));
	}

	@RequestMapping("getStoresForFlexbox")
	public void getStoresForFlexbox(@RequestParam String txtsitecode,
			HttpServletResponse response) throws Exception {
		List<MstStore> stores = service.getStoresByName(txtsitecode);
		response.getWriter().print(
				MasterJSONUtil.getJsonForStoreFlexBox(stores));
	}

	@RequestMapping("getUserdetailforUpdate")
	public void getUserdetailforUpdate(@RequestParam Long txtempid,
			HttpServletResponse response) throws Exception {
		MstEmployee employee = service.searchEmployeeById(txtempid);
		response.getWriter().print(
				MasterJSONUtil.getJsonForEmployeeToUpdateById(employee));
	}

	@RequestMapping("searchUserPage")
	public String showSearchUserPage() {
		return "master/searchuser";
	}

	@RequestMapping("getEmpSearchBy")
	@Transactional
	public void getEmpSearchBy(@RequestParam(required = false) String idEmp,
			@RequestParam(required = false) String idZone,
			@RequestParam(required = false) String idLocation,
			@RequestParam(required = false) String idRole,
			@RequestParam(required = false) String idStore,
			HttpServletResponse response) throws Exception {
		List<MstEmployee> list = new ArrayList<MstEmployee>();
		if (idEmp != null && !StringUtils.isEmpty(idEmp)) {
			MstEmployee emp = service.searchEmployeeById(Long.parseLong(idEmp));
			list.add(emp);
		} else if (idZone != null && !StringUtils.isEmpty(idZone)
				&& !idZone.equals("-1")) {
			list = service.searchEmployeeByZone(Long.parseLong(idZone));
		} else if (idLocation != null && !StringUtils.isEmpty(idLocation)
				&& !idLocation.equals("-1")) {
			list = service.searchEmployeeByLocation(Long.parseLong(idLocation));
		} else if (idRole != null && !StringUtils.isEmpty(idRole)
				&& !idRole.equals("-1")) {
			list = service.searchEmployeeByRole(Long.parseLong(idRole));
		} else if (idStore != null && !StringUtils.isEmpty(idStore)
				&& !idStore.equals("-1")) {
			list = service.searchEmployeeBySiteId(idStore);
		}
		response.getWriter().print(
				MasterJSONUtil.getJSONGridDataForEmpSearch(list));
	}

	@RequestMapping("downloadEmployeeMasterdtl")
	public void downloadEmployeeMasterData(HttpServletResponse response)
			throws Exception {
		String fileName = System.currentTimeMillis() + WebConstants.CSV_EXT;
		List<MstEmployee> list = service.getAllEmployees();
		List<String[]> listemp = CommonUtil.writeEmployeeData(list);
		CSVWriter writer = new CSVWriter(
				new FileWriter(new File(dir, fileName)));
		writer.writeAll(listemp);
		writer.close();
		BufferedReader bis = new BufferedReader(new FileReader(new File(dir,
				fileName)));
		String line = bis.readLine();
		// response.getOutputStream().write(WebConstants.MCH_HEADER_LINE);
		// response.getOutputStream().write(WebConstants.NEW_LINE);
		while (line != null) {
			response.getOutputStream().write(line.getBytes());
			response.getOutputStream().write(WebConstants.NEW_LINE);
			line = bis.readLine();
		}
		bis.close();
		response.setContentType("text/csv");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		logger.info(" --- Employee Download File Created --- " + fileName);
		response.getOutputStream().flush();
	}

	@RequestMapping("userMch")
	public String showUserMchPage() {
		return "master/usermch";
	}

	@RequestMapping("downloadMCHUser")
	public void downloadF1UserFile(@RequestParam Long sendEmpId,
			@RequestParam String type, HttpServletResponse response)
			throws Exception {
		String fileName = System.currentTimeMillis() + WebConstants.CSV_EXT;
		CSVWriter writer = new CSVWriter(
				new FileWriter(new File(dir, fileName)));
		List<String[]> f1StrMap = new ArrayList<String[]>();
		if (type.equals("f1")) {
			MstEmployee emp = service.getEmpF1Info(sendEmpId);
			for (Map_user_MCH_F1 userf1 : emp.getMapUserMchF1s()) {
				f1StrMap.add(new String[] { userf1.getMch().getMcCode() });

			}
		} else if (type.equals("f2")) {
			MstEmployee emp = service.getEmpF2Info(sendEmpId);
			for (Map_user_MCH_F2 userf2 : emp.getMapUserMchF2s()) {
				f1StrMap.add(new String[] { userf2.getMch().getMcCode() });

			}
		} else {
			MstEmployee emp = service.getEmpF3Info(sendEmpId);
			for (Map_user_MCH_F3 userf3 : emp.getMapUserMchF3s()) {
				f1StrMap.add(new String[] { userf3.getMch().getMcCode() });

			}
		}
		writer.writeAll(f1StrMap);
		writer.close();
		BufferedReader bis = new BufferedReader(new FileReader(new File(dir,
				fileName)));
		String line = bis.readLine();
		response.getOutputStream().write(WebConstants.MC_USER_HEADER_LINE);
		response.getOutputStream().write(WebConstants.NEW_LINE);
		while (line != null) {
			response.getOutputStream().write(line.getBytes());
			response.getOutputStream().write(WebConstants.NEW_LINE);
			line = bis.readLine();
		}
		bis.close();
		response.setContentType("text/csv");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		logger.info(" --- MCH Download File Created --- " + fileName);
		response.getOutputStream().flush();
	}

	@RequestMapping(value = "uploadfile", method = RequestMethod.POST)
	public String uploadMCHUserFile(@RequestParam Long sendEmpId,
			@RequestParam(required=false) MultipartFile filef1,
			@RequestParam(required=false) MultipartFile filef2,
			@RequestParam(required=false) MultipartFile filef3,
			@RequestParam int sendProfileId, HttpServletRequest request)
			throws Exception {
		CSVReader reader = null;
		try {
			if(sendProfileId==1 && !filef1.isEmpty()){
				reader = new CSVReader(new InputStreamReader(
						filef1.getInputStream()));
			} else if (sendProfileId==2 && !filef2.isEmpty()){
				reader = new CSVReader(new InputStreamReader(
						filef2.getInputStream()));
			} else {
				reader = new CSVReader(new InputStreamReader(
						filef3.getInputStream()));
			}			
				List<String[]> list = reader.readAll();
				List<String> mcCodeList = CommonUtil.getMCCodeList(list);				
				boolean result = service.updateEmployeeMCH(mcCodeList,
						sendProfileId, sendEmpId);
				if (result) {
					request.setAttribute("msg", "File Processing Completed");
				} else {
					request.setAttribute("msg", "Error !!! ");
				}
			
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return "/master/usermch";
	}
	
	

}
