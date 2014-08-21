package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fks.pwm.entity.MstCalender;

public interface CalendarRepo extends JpaRepository<MstCalender, Long>{

	@Query(nativeQuery=true,value="select * from mst_calender c where MONTH(c.cal_date)=?1 and YEAR(c.cal_date)=?2")
	public List<MstCalender> getCalendarsByMonthAndYear(String month,String year);
	
	@Query(nativeQuery=true,value="select * from mst_calender c where YEAR(c.cal_date)=?1")
	public List<MstCalender> getCalendarsByYear(String year);
	
}
