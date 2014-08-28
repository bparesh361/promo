package com.fks.pwm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fks.pwm.entity.MstDepartment;
import com.fks.pwm.entity.MstProblem;
import com.fks.pwm.entity.MstPromotionType;
import com.fks.pwm.service.ODSService;
import com.fks.pwm.service.OtherMasterService;
import com.fks.pwm.util.ProposalJsonUtil;
import com.fks.pwm.vo.ArticleVO;

@Controller
public class ProposalController {
	
	@Autowired
	private OtherMasterService otherMasterService;
	
	@Autowired
	private ODSService odsService;
	
	@RequestMapping("showProposalPage")
	public String showProposalPage() throws Exception {
		return "proposal/proposal";
	}
	
	@RequestMapping("getDeptSelect")
	public void getDepartmentForProposal(HttpServletResponse response) throws Exception {
		List<MstDepartment> list = otherMasterService.getAllDepartments();
		JSONObject obj = ProposalJsonUtil.getJsonForDepartment(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("getProblemSelect")
	public void getProblemForProposal(HttpServletResponse response) throws Exception {
		List<MstProblem> list = otherMasterService.getAllProblem();
		JSONObject obj = ProposalJsonUtil.getJsonForProblem(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("getPromotionType")
	public void getPromotionType(HttpServletResponse response) throws Exception {
		List<MstPromotionType> list = otherMasterService.getAllMstPromotionType();
		JSONObject obj = ProposalJsonUtil.getJsonForPromotionType(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("validateArticleORMCCode")
	public void validateArticleMCCode(@RequestParam(required=false) String isArticleEntered, 
			@RequestParam(required=false) String mcCode,
			@RequestParam(required=false)String articleCode,
			HttpServletResponse response) throws Exception {
		try {
		ArticleVO vo = odsService.getArticle(articleCode);
		JSONObject obj = new JSONObject();
		if(vo.getArtDesc()==null){
			obj.put("respCode", "0");			
		} else {			
			obj.put("respCode", "1");
			obj.put("articleCode", vo.getArtCode());	
			obj.put("mcCode",vo.getMcCode());
			obj.put("mcDesc",vo.getMcDesc());
			obj.put("articleDesc",vo.getArtDesc());
		}
		response.getWriter().print(obj);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
