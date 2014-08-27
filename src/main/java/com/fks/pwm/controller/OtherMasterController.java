package com.fks.pwm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import com.fks.pwm.service.MasterService;
import com.fks.pwm.service.OtherMasterService;
import com.fks.pwm.util.OtherMasterJSONUtil;
import com.fks.pwm.util.WebConstants;

@Controller
public class OtherMasterController {

	@Autowired
	private OtherMasterService service;

	@Autowired
	private MasterService masterService;

	@RequestMapping("showCampaignPage")
	public String showCampaignPage() {
		return "master/other/campaign";
	}

	@RequestMapping("showDepartmentPage")
	public String showDepartmentPage() {
		return "master/other/department";
	}

	@RequestMapping("showStoreProposalPage")
	public String showStoreProposalPage() {
		return "master/other/proposalrptemail";
	}

	@RequestMapping("showCampaignData")
	public void showCampaignData(HttpServletResponse response) throws Exception {
		List<MstCampaign> list = service.getAllCampaign();
		JSONObject obj = OtherMasterJSONUtil.getJsonForLeadTimeStatus(list);
		response.getWriter().print(obj);
	}

	@RequestMapping("getAllUsersForStorePRndingProposal")
	public void getAllUsersForStorePRndingProposal(HttpServletResponse response)
			throws Exception {
			List<MstReportEmail> list = service.getAllMstReportEmail();
			JSONObject obj = OtherMasterJSONUtil.getJsonForReportEmail(list);
			response.getWriter().print(obj);
	}
	
	@RequestMapping("createStoreProposalReport")
	public String createStoreProposalReport(@RequestParam Long zoneSelect, @RequestParam String tbEmailId, 
			HttpServletRequest request) throws Exception {
		service.createStoreProposal(zoneSelect, tbEmailId);
		request.setAttribute("msg", "Store Proposal Email Successfully Configured");
		return "master/other/proposalrptemail";
	}

	@RequestMapping("getAlldepartmentDetail.do")
	public void getAlldepartmentDetail(HttpServletResponse response)
			throws Exception {
		List<MstDepartment> list = service.getAllDepartments();
		JSONObject obj = OtherMasterJSONUtil.getJsonObjectForDepartment(list);
		response.getWriter().print(obj);
	}

	@RequestMapping("updateCampaign")
	public String updateCampaign(@ModelAttribute MstCampaign campaign,
			HttpServletRequest request) {
		boolean result = service.udpateCampaign(campaign);
		if (result) {
			request.setAttribute("msg",
					"Campaign created / updated successfully with Id "
							+ campaign.getCampaignId());
		} else {
			request.setAttribute("msg", "Error !!!");
		}
		return "master/other/campaign";
	}

	@RequestMapping("showCalendarPage")
	public String showCalendarPage() {
		return "master/other/calendar";
	}

	@RequestMapping("showMarketingPage")
	public String showMarketingPage() {
		return "master/other/marketing";
	}

	@RequestMapping("showReasonPage")
	public String showReasonPage() {
		return "master/other/rejection";
	}

	@RequestMapping("showProblemPage")
	public String showProblemPage() {
		return "master/other/problem";
	}

	@RequestMapping("showZonePage")
	public String showZonePage() {
		return "master/other/zone";
	}

	@RequestMapping("showPromotionTypePage")
	public String showPromotionTypePage() {
		return "master/other/promotion";
	}

	@RequestMapping("showTaskPage")
	public String showTaskpage() {
		return "master/other/task";
	}

	@RequestMapping("showTaskData")
	public void showTaskData(HttpServletResponse response) throws Exception {
		List<MstTask> list = service.getAllTask();
		JSONObject obj = OtherMasterJSONUtil.getJsonForTask(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("showCalendarData")
	public void showCalendarData(HttpServletResponse response) throws Exception {
		List<MstCalender> list = service.getAllCalendar();
		JSONObject obj = OtherMasterJSONUtil.getJsonForCalendar(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("showZoneData")
	public void showZoneData(HttpServletResponse response) throws Exception {
		List<MstZone> list = masterService.findAllZones();
		JSONObject obj = OtherMasterJSONUtil.getJsonForZone(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("getAllProblem")
	public void showProblemData(HttpServletResponse response) throws Exception {
		List<MstProblem> list = service.getAllProblem();
		JSONObject obj = OtherMasterJSONUtil.getJsonForProblem(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("getAllMarketingTypes")
	public void getAllMarketingTypes(HttpServletResponse response)
			throws Exception {
		List<MstMktg> list = service.getAllMarketing();
		JSONObject obj = OtherMasterJSONUtil.getJsonForMarketing(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("getAllPromotionType")
	public void getAllPromotionType(HttpServletResponse response)
			throws Exception {
		List<MstPromotionType> list = service.getAllMstPromotionType();
		JSONObject obj = OtherMasterJSONUtil.getJsonForPromotion(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("submitMktgMaster")
	public String submitMarketingMaster(@RequestParam String mktgName,
			@RequestParam Byte selStatus,
			@RequestParam(required = false) Long txMktgID,
			HttpServletRequest request) {
		MstMktg mktg = service.createUpdateMkgt(mktgName, selStatus, txMktgID);
		request.setAttribute("msg", "Marketing Type Created / Updated with Id "
				+ mktg.getMktgId());
		return "master/other/marketing";
	}

	@RequestMapping("submitZoneMaster")
	public String submitZoneMaster(@RequestParam String zonename,
			@RequestParam Byte selStatus,
			@RequestParam(required = false) Long txnzoneid,
			@RequestParam String zonecode, HttpServletRequest request) {
		MstZone zone = service.createUpdateZone(zonename, selStatus, txnzoneid,
				zonecode);
		request.setAttribute("msg", "Zone Type Created / Updated with Id "
				+ zone.getZoneId());
		return "master/other/zone";
	}

	@RequestMapping("submitTaskMaster")
	public String submitTaskMaster(@RequestParam String taskname,
			@RequestParam Byte selStatus,
			@RequestParam(required = false) Long txTaskID,
			HttpServletRequest request) {
		MstTask task = service.createUpdateTask(taskname, selStatus, txTaskID);
		request.setAttribute("msg", "Task Type Created / Updated with Id "
				+ task.getTaskId());
		return "master/other/task";
	}

	@RequestMapping("submitProblem")
	public String submitProblem(@RequestParam String problemname,
			@RequestParam Byte selStatus,
			@RequestParam(required = false) Long txProblemID,
			RedirectAttributes attributes) {
		MstProblem problem = service.createUpdateProblem(problemname,
				selStatus, txProblemID);
		attributes.addFlashAttribute(
				"msg",
				"Problem Type Created / Updated with Id "
						+ problem.getProblemTypeId());
		return "redirect:showProblemPage.do";
	}

	@RequestMapping("getAllCalendarByYearAndMonth")
	public void getAllCalendarByYearAndMonth(
			@RequestParam(required = false) String year,
			@RequestParam(required = false) String month,
			HttpServletResponse response) throws Exception {
		List<MstCalender> list = null;
		if (month != null) {
			list = service.getAllCalendarsByMonthAndYear(month, year);
		} else {
			list = service.getAllCalendarsByYear(year);
		}
		JSONObject obj = OtherMasterJSONUtil.getJsonForCalendar(list);
		response.getWriter().print(obj);
	}

	@RequestMapping("getAllRejection")
	public void getAllRejection(@RequestParam Byte isApprover,
			HttpServletResponse response) throws Exception {
		List<MstReasonRejection> list = service.getAllRejections(isApprover);
		JSONObject obj = OtherMasterJSONUtil.getJsonForReason(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}

	@RequestMapping("submitReasonHO")
	public String submitReasonHO(@RequestParam String rejectionname,
			@RequestParam Byte selStatus,
			@RequestParam(required = false) Long txRejectionID,
			HttpServletRequest request) {
		MstReasonRejection reason = service.createUpdateReason(rejectionname,
				selStatus, txRejectionID, WebConstants.FALSE_BYTE);
		request.setAttribute("msg", "Reason Type Created / Updated with Id "
				+ reason.getReasonRejectionId());
		return "master/other/rejection";
	}

	@RequestMapping("submitReason")
	public String submitReason(@RequestParam String rejectionname1,
			@RequestParam Byte selStatus1,
			@RequestParam(required = false) Long txRejectionID1,
			HttpServletRequest request) {
		MstReasonRejection reason = service.createUpdateReason(rejectionname1,
				selStatus1, txRejectionID1, WebConstants.TRUE_BYTE);
		request.setAttribute("msg", "Reason Type Created / Updated with Id "
				+ reason.getReasonRejectionId());
		return "master/other/rejection";
	}

	@RequestMapping("submitDepartment")
	public String submitDepartment(@RequestParam String deptName,
			@RequestParam Byte selStatus,
			@RequestParam(required = false) Long txtdeptID,
			HttpServletRequest request) {
		MstDepartment department = service.createUpdateDepartment(deptName,
				selStatus, txtdeptID);
		request.setAttribute("msg", "Department Created / Updated with Id "
				+ department.getMstDeptId());
		return "master/other/department";
	}

}
