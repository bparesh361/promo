package com.fks.pwm.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fks.pwm.vo.ArticleVO;

@Service
public class ODSService {

	@Autowired()
	private DataSource dataSource1;
	
	public ArticleVO getArticle(String articleCode) throws Exception {
		articleCode = String.format("%018d", Integer.parseInt(articleCode));
		PreparedStatement pstmt = dataSource1.getConnection().prepareStatement("select a.ART_DESC, a.MC_CODE, mch.MC_DESC, a.brand_code, b.brand_desc from ARTICLE a, MCH mch , brand b where a.mc_code=mch.mc_code and b.brand_code=a.brand_code and "
				+ "a.ART_CODE=? order by a.load_date desc");
		pstmt.setString(1, articleCode);
		ResultSet rs = pstmt.executeQuery();
		ArticleVO vo = new ArticleVO();
		vo.setArtCode(articleCode);
		while(rs.next()){			
			vo.setArtDesc(rs.getString(1));
			vo.setMcCode(rs.getString(2));
			vo.setMcDesc(rs.getString(3));
			vo.setBrandCode(rs.getString(4));
			vo.setBrandDesc(rs.getString(5));
			return vo;
		}
		return vo;
	}
	
}
