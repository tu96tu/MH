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
import com.tutu.vo.QuestionInfoVO;
import com.tutu.vo.UserInfoVO;
@Repository
public class QuestionInfoDao implements DAOSupper<QuestionInfoVO>{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(QuestionInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into question_info(exam_no,qu_title,qu_option1,qu_option2,qu_option3,qu_option4,qu_option1_score,qu_option2_score,qu_option3_score,qu_option4_score) values(?,?,?,?,?,?,?,?,?,?)",
				t.getExamNo(),t.getQuTitle(),t.getQuOption1(),t.getQuOption2(),t.getQuOption3(),t.getQuOption4(),t.getQuOption1Score(),t.getQuOption2Score(),t.getQuOption3Score(),t.getQuOption4Score());
	}

	@Override
	public void delete(QuestionInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from question_info where qu_no = ?",t.getQuNo());
	}

	@Override
	public void modify(QuestionInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update question_info set qu_title=?,qu_option1=?,qu_option2=?,qu_option3=?,qu_option4=?,qu_option1_score=?,qu_option2_score=?,qu_option3_score=?,qu_option4_score=? where qu_no=?",
				t.getQuTitle(),t.getQuOption1(),t.getQuOption2(),t.getQuOption3(),t.getQuOption4(),t.getQuOption1Score(),t.getQuOption2Score(),t.getQuOption3Score(),t.getQuOption4Score(),t.getQuNo());
	}

	@Override
	public List<QuestionInfoVO> findAll() {
		// TODO Auto-generated method stub
		return  this.jdbcTemplate.query("select * from question_info ",
				new RowMapper<QuestionInfoVO>(){

					@Override
					public QuestionInfoVO mapRow(ResultSet rs, int index) 
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public List<QuestionInfoVO> findAll(int page, int rowMax) {
		Object[] args = new Object[] {(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from question_info order by qu_no desc limit ?,?",args,
				new RowMapper<QuestionInfoVO>(){

					@Override
					public QuestionInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long count(){
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from question_info");
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}

	@Override
	public QuestionInfoVO findByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionInfoVO findByNo(QuestionInfoVO t) {
		// TODO Auto-generated method stub
		String sql ="select * from question_info where qu_no=?";
		Object[] args = new Object[] {t.getQuNo()};
		List<QuestionInfoVO> vo =  this.jdbcTemplate.query(sql,args,new RowMapper<QuestionInfoVO>(){
					@Override
					public QuestionInfoVO mapRow(ResultSet rs, int index)throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
		if(vo.isEmpty())
			return null;
		return (QuestionInfoVO)vo.get(0);   
	}
	
	public List<QuestionInfoVO> findByExamNo(QuestionInfoVO t) {
		// TODO Auto-generated method stub
		Object[] args = new Object[] {t.getExamNo()};
		return  this.jdbcTemplate.query("select * from question_info where exam_no =? ",args,
				new RowMapper<QuestionInfoVO>(){

					@Override
					public QuestionInfoVO mapRow(ResultSet rs, int index) 
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		}); 
	}
	
	public List<QuestionInfoVO> findByExamNo(QuestionInfoVO t,int page, int rowMax) {
		Object[] args = new Object[] {t.getExamNo(),(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from question_info where exam_no =? order by qu_no limit ?,?",args,
				new RowMapper<QuestionInfoVO>(){

					@Override
					public QuestionInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long count(QuestionInfoVO t){
		Object[] args = new Object[] {t.getExamNo()};
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from question_info where exam_no =?",args);
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}

	@Override
	public List<QuestionInfoVO> search(String str) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%"};
		return  this.jdbcTemplate.query("select * from question_info where qu_no like ? or qu_title like ?",obj,
				new RowMapper<QuestionInfoVO>(){

					@Override
					public QuestionInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	private QuestionInfoVO load(ResultSet rs) throws SQLException{
		QuestionInfoVO vo = new QuestionInfoVO();
		vo.setQuNo(rs.getLong("qu_no"));
		vo.setExamNo(rs.getLong("exam_no"));
		vo.setQuTitle(rs.getString("qu_title"));
		vo.setQuOption1(rs.getString("qu_option1"));
		vo.setQuOption2(rs.getString("qu_option2"));
		vo.setQuOption3(rs.getString("qu_option3"));
		vo.setQuOption4(rs.getString("qu_option4"));
		vo.setQuOption1Score(rs.getInt("qu_option1_score"));
		vo.setQuOption2Score(rs.getInt("qu_option2_score"));
		vo.setQuOption3Score(rs.getInt("qu_option3_score"));
		vo.setQuOption4Score(rs.getInt("qu_option4_score"));
		return vo;
	}

}
