package com.fks.pwm.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstLeadTime;
import com.fks.pwm.entity.MstStatus;
import com.fks.pwm.service.MasterService;
import com.fks.pwm.util.CommonUtil;
import com.fks.pwm.util.MasterJSONUtil;
import com.fks.pwm.util.WebConstants;
import com.fks.pwm.vo.LeadTimeVO;
import com.fks.pwm.vo.MchVO;

@Controller
public class MasterController {

	private static final Logger logger = Logger
			.getLogger(MasterController.class);

	@Autowired
	private MasterService masterService;
	
	@Value("${download_dir}")
	private String dir;

	@RequestMapping("show_lead_time")
	public String showLeadTimePage() {
		return "master/leadtime";
	}

	@RequestMapping("getStatusForLeadTime")
	public void getStatusForLeadTime(HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		List<MstStatus> list = masterService.getLeadTimeFromMstStatus();
		JSONObject obj = MasterJSONUtil.getJsonForLeadTimeStatus(list);
		out.print(obj);
	}

	@RequestMapping("getLeadTimeForPromoSetUp")
	public void getLeadTimeForPromoSetUp(HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		List<MstLeadTime> list = masterService.getLeadTime();
		JSONObject obj = MasterJSONUtil.getJsonLeadTimeForPromoSetUp(list
				.get(0));
		out.print(obj);
	}

	@RequestMapping("updateLeadTime")
	public String updateLeadTime(@ModelAttribute LeadTimeVO leadTime) {
		masterService.updateLeadTime(leadTime);
		return "master/leadtime";
	}

	@RequestMapping("updatePromoLeadTime")
	public String updatePromoLeadTime(@RequestParam int leadTimeValue) {
		masterService.updatePromoLeadTime(leadTimeValue);
		return "master/leadtime";
	}

	@RequestMapping("mch")
	public String showMCH() {
		return "/master/mch";
	}

	@RequestMapping("getAllMCH")
	public void getAllMCH(HttpServletResponse response) throws Exception {
		List<Mch> list = masterService.getAllMCH();
		JSONObject object = MasterJSONUtil.getJsonForMCH(list);
		response.getWriter().print(object);
	}

	@RequestMapping("mchUpload")
	public String uploadFile(@RequestParam("file") MultipartFile file,
			HttpServletRequest request,HttpSession session) throws Exception {
		CSVReader reader = null;
		try {
			if (!file.isEmpty()) {
				reader = new CSVReader(new InputStreamReader(
						file.getInputStream()));
				List<String[]> list = reader.readAll();
				MstEmployee emp = (MstEmployee)session.getAttribute("emp");
				for (String[] line : list) {
					MchVO mchvo = CommonUtil.getMCHFromCSVLine(line,emp);
					boolean result = masterService.updateMCH(mchvo,emp);
					logger.info(" --- Processing MCH File Line --- " + mchvo
							+ " # Result # " + result);
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		request.setAttribute("msg", "File Processing Completed");
		return "/master/mch";
	}
	
	@RequestMapping("downloadMCH")
	public void downloadMCH(HttpServletResponse response) throws Exception{		
		 String fileName = System.currentTimeMillis()+ WebConstants.CSV_EXT;		 
         List<Mch> list = masterService.getAllMCH();
         CSVWriter writer = new CSVWriter(new FileWriter(new File(dir,fileName)));
         List<String[]> listCSV = CommonUtil.getMCHList(list);
         writer.writeAll(listCSV);
         writer.close();
         BufferedReader bis = new BufferedReader(new FileReader(new File(dir,fileName)));
         String line = bis.readLine();
//         response.getOutputStream().write(WebConstants.MCH_HEADER_LINE);
         response.getOutputStream().write(WebConstants.NEW_LINE);
         while(line!=null){
        	 response.getOutputStream().write(line.getBytes());
        	 response.getOutputStream().write(WebConstants.NEW_LINE);
        	 line = bis.readLine();
         }
         bis.close();
         response.setContentType("text/csv");
         response.setHeader("Content-disposition", "attachment; filename=" + fileName);
         logger.info(" --- MCH Download File Created --- " + fileName);
         response.getOutputStream().flush();
	}
	
}
