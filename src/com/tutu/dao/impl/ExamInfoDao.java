package com.tutu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.tutu.dao.DAOSupper;
import com.tutu.vo.ExamInfoVO;
@Repository
public class ExamInfoDao implements DAOSupper<ExamInfoVO>{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(ExamInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into exam_info(num,exam_title,exam_intrd,exam_result1,exam_result2,exam_result3,exam_result4) values(?,?,?,?,?,?,?)",
				t.getNum(),t.getExamTitle(),t.getExamIntrd(),t.getExamResult1(),t.getExamResult2(),t.getExamResult3(),t.getExamResult4());
	}

	@Override
	public void delete(ExamInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from question_info where exam_no =?",t.getExamNo());
		this.jdbcTemplate.update("delete from exam_info where exam_no =?",t.getExamNo());
	}

	@Override
	public void modify(ExamInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update exam_info set num=?,exam_title=?,exam_intrd=?,exam_result1=?,exam_result2=?,exam_result3=?,exam_result4=? where exam_no=?",
				t.getNum(),t.getExamTitle(),t.getExamIntrd(),t.getExamResult1(),t.getExamResult2(),t.getExamResult3(),t.getExamResult4(),t.getExamNo());
	}

	@Override
	public List<ExamInfoVO> findAll() {
		// TODO Auto-generated method stub
		return  this.jdbcTemplate.query("select * from exam_info ",
				new RowMapper<ExamInfoVO>(){

					@Override
					public ExamInfoVO mapRow(ResultSet rs, int index) 
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}

	public List<ExamInfoVO> findAll(int page, int rowMax) {
		Object[] args = new Object[] {(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from exam_info order by exam_no desc limit ?,?",args,
				new RowMapper<ExamInfoVO>(){

					@Override
					public ExamInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long count(){
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from exam_info");
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}
	
	@Override
	public ExamInfoVO findByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamInfoVO findByNo(ExamInfoVO t) {
		// TODO Auto-generated method stub
		String sql ="select * from exam_info where exam_no=?";
		Object[] args = new Object[] {t.getExamNo()};
		List<ExamInfoVO>vo =  this.jdbcTemplate.query(sql,args,new RowMapper<ExamInfoVO>(){
					@Override
					public ExamInfoVO mapRow(ResultSet rs, int index)throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
		if(vo.isEmpty())
			return null;
		return (ExamInfoVO)vo.get(0); 
	}

	@Override
	public List<ExamInfoVO> search(String str) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%","%"+str+"%"};
		return  this.jdbcTemplate.query("select * from exam_info where exam_no like ? or exam_title like ? or num like ? ",obj,
				new RowMapper<ExamInfoVO>(){

					@Override
					public ExamInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	private ExamInfoVO load(ResultSet rs) throws SQLException{
		ExamInfoVO vo = new ExamInfoVO();
		vo.setExamNo(rs.getLong("exam_no"));
		vo.setNum(rs.getInt("num"));
		vo.setExamTitle(rs.getString("exam_title"));
		vo.setExamIntrd(rs.getString("exam_intrd"));
		vo.setExamResult1(rs.getString("exam_result1"));
		vo.setExamResult2(rs.getString("exam_result2"));
		vo.setExamResult3(rs.getString("exam_result3"));
		vo.setExamResult4(rs.getString("exam_result4"));
		return vo;
		
	}

}
