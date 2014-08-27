package com.fks.pwm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.MstCalender;
import com.fks.pwm.entity.MstCampaign;
import com.fks.pwm.entity.MstDepartment;
import com.fks.pwm.entity.MstMktg;
import com.fks.pwm.entity.MstProblem;
import com.fks.pwm.entity.MstPromotionType;
import com.fks.pwm.entity.MstReasonRejection;
import com.fks.pwm.entity.MstReportEmail;
import com.fks.pwm.entity.MstReportType;
import com.fks.pwm.entity.MstTask;
import com.fks.pwm.entity.MstZone;
import com.fks.pwm.repository.CalendarRepo;
import com.fks.pwm.repository.CampaignRepo;
import com.fks.pwm.repository.MstCampaignRepo;
import com.fks.pwm.repository.MstDepartmentRepo;
import com.fks.pwm.repository.MstMktgRepo;
import com.fks.pwm.repository.MstProblemRepo;
import com.fks.pwm.repository.MstPromotionTypeRepo;
import com.fks.pwm.repository.MstReasonRejectionRepo;
import com.fks.pwm.repository.MstReportEmailRepo;
import com.fks.pwm.repository.MstReportTypeRepo;
import com.fks.pwm.repository.MstTaskRepo;
import com.fks.pwm.repository.ZoneRepo;

@Service
@Transactional
public class OtherMasterService {

	@Autowired
	private CampaignRepo campaignRepo;

	@Autowired
	private CalendarRepo calendarRepo;

	@Autowired
	private MstMktgRepo mktgRepo;

	@Autowired
	private MstReasonRejectionRepo reasonRejectionRepo;
	
	@Autowired
	private MstProblemRepo problemRepo;
	
	@Autowired
	private MstPromotionTypeRepo promotionRepo;
	
	@Autowired
	private MstTaskRepo taskRepo;
	
	@Autowired
	private ZoneRepo zoneRepo;	
	
	@Autowired
	private MstDepartmentRepo departmentRepo;
	
	@Autowired
	private MstReportEmailRepo mstReportEmailRepo;
	
	@Autowired
	private MstReportTypeRepo reportTypeRepo;

	@Transactional(readOnly = true)
	public List<MstCampaign> getAllCampaign() {
		return campaignRepo.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<MstReportEmail> getAllMstReportEmail() {
		return mstReportEmailRepo.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<MstDepartment> getAllDepartments() {
		return departmentRepo.findAll();
	}

	@Transactional(readOnly = true)
	public List<MstCalender> getAllCalendar() {
		return calendarRepo.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<MstProblem> getAllProblem() {
		return problemRepo.findAll();
	}

	@Transactional(readOnly = true)
	public List<MstMktg> getAllMarketing() {
		return mktgRepo.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<MstTask> getAllTask() {
		return taskRepo.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<MstPromotionType> getAllMstPromotionType() {
		return promotionRepo.findAll();
	}

	public boolean udpateCampaign(MstCampaign campaign) {
		if (campaign == null) {
			return false;
		}
		if (campaign.getCampaignId() == null) {
			campaignRepo.save(campaign);
		} else {
			MstCampaign dbCampaign = campaignRepo.findOne(campaign
					.getCampaignId());
			dbCampaign.setCampaignName(campaign.getCampaignName());
			dbCampaign.setIsActive(campaign.getIsActive());
		}
		return true;
	}

	public boolean udpateCalendar(MstCalender calender) {
		if (calender == null) {
			return false;
		}
		if (calender.getMstCalenderId() == null) {
			calendarRepo.save(calender);
		} else {
			MstCalender dbCalendar = calendarRepo.findOne(calender
					.getMstCalenderId());
			dbCalendar.setCalDate(calender.getCalDate());
			dbCalendar.setDateDescription(calender.getDateDescription());
		}
		return true;
	}

	@Transactional(readOnly = true)
	public List<MstCalender> getAllCalendarsByMonthAndYear(String month,
			String year) {
		return calendarRepo.getCalendarsByMonthAndYear(month, year);
	}

	@Transactional(readOnly = true)
	public List<MstCalender> getAllCalendarsByYear(String year) {
		return calendarRepo.getCalendarsByYear(year);
	}

	public MstMktg createUpdateMkgt(String mktgName, Byte status, Long mktgId) {
		MstMktg mktg = null;
		if (mktgId == null) {
			mktg = new MstMktg();
		} else {
			mktg = mktgRepo.findOne(mktgId);
		}
		mktg.setIsBlocked(status);
		mktg.setMktgName(mktgName);
		if (mktgId == null) {
			mktgRepo.save(mktg);
		}
		return mktg;
	}
	
	public MstDepartment createUpdateDepartment(String deptName, Byte status, Long deptId) {
		MstDepartment dept = null;
		if (deptId == null) {
			dept = new MstDepartment();
		} else {
			dept = departmentRepo.findOne(deptId);
		}
		dept.setIsBlocked(status);
		dept.setDeptName(deptName);
		if (deptId == null) {
			departmentRepo.save(dept);
		}
		return dept;
	}
	
	public MstZone createUpdateZone(String zoneName, Byte status, Long zoneId, String zoneCode) {
		MstZone zone = null;
		if (zoneId == null) {
			zone = new MstZone();
		} else {
			zone = zoneRepo.findOne(zoneId);
		}
		zone.setIsBlocked(status);
		zone.setZoneName(zoneName);
		zone.setZoneCode(zoneCode);
		if (zoneId == null) {
			zoneRepo.save(zone);
		}
		return zone;
	}
	
	public MstProblem createUpdateProblem(String problemName, Byte status, Long problemId) {
		MstProblem problem = null;
		if (problemId == null) {
			problem = new MstProblem();
		} else {
			problem = problemRepo.findOne(problemId);
		}
		problem.setIsBlocked(status);
		problem.setProblemName(problemName);
		if (problemId == null) {
			problemRepo.save(problem);
		}
		return problem;
	}
	
	public MstTask createUpdateTask(String taskName, Byte status, Long taskId) {
		MstTask task = null;
		if (taskId == null) {
			task = new MstTask();
		} else {
			task = taskRepo.findOne(taskId);
		}
		task.setIsBlocked(status);
		task.setTaskName(taskName);
		if (taskId == null) {
			taskRepo.save(task);
		}
		return task;
	}

	public MstReasonRejection createUpdateReason(String reasonName,
			Byte status, Long reasonId, byte isHO) {
		MstReasonRejection reason = null;
		if (reasonId == null) {
			reason = new MstReasonRejection();
		} else {
			reason = reasonRejectionRepo.findOne(reasonId);
		}
		reason.setIsBlocked(status);
		reason.setReasonName(reasonName);
		reason.setIsApprover(isHO);
		if (reasonId == null) {
			reasonRejectionRepo.save(reason);
		}
		return reason;
	}

	public List<MstReasonRejection> getAllRejections(Byte isApprover) {
		return reasonRejectionRepo.getRejectionByApprover(isApprover);
	}
	
	
	public void createStoreProposal(Long zoneId, String emailId){
		MstZone zone = zoneRepo.findOne(zoneId);
		MstReportType reportType = reportTypeRepo.findOne(6l);
		MstReportEmail reportEmail = new MstReportEmail(); 
		reportEmail.setMstZoneId(zone.getZoneCode());
		reportEmail.setMstZoneName(zone.getZoneName());
		reportEmail.setMstReportType(reportType);
		mstReportEmailRepo.save(reportEmail);
	}

}
