package com.tutu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tutu.dao.DAOSupper;
import com.tutu.vo.TestResultVO;
import com.tutu.vo.UserInfoVO;
@Repository
public class TestResultInfoDao implements DAOSupper<TestResultVO>{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Override
	public void add(TestResultVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into test_result(user_no,exam_no,exam_score,test_result) values(?,?,?,?)",
				t.getUserNo(),t.getExamNo(),t.getExamScore(),t.getTestResult());
	}

	@Override
	public void delete(TestResultVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from test_result where test_no = ?",t.getTestNo());
	}

	@Override
	public void modify(TestResultVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update test_result set user_no=?,exam_no=?,exam_score=?,test_result=? where test_no=?",
				t.getUserNo(),t.getExamNo(),t.getExamScore(),t.getTestResult(),t.getTestNo());
	}

	@Override
	public List<TestResultVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestResultVO findByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TestResultVO find(TestResultVO t){
		String sql ="select * from test_result where user_no=? and exam_no=?";
		Object[] args = new Object[] {t.getUserNo(),t.getExamNo()};
		//System.out.println(args[0]);
		List<TestResultVO> vo =  this.jdbcTemplate.query(sql,args,new RowMapper<TestResultVO>(){
					@Override
					public TestResultVO mapRow(ResultSet rs, int index)throws SQLException {
						// TODO Auto-generated method stub
						TestResultVO test = new TestResultVO();
						test.setExamNo(rs.getLong("exam_no"));
						test.setExamScore(rs.getInt("exam_score"));
						test.setTestNo(rs.getLong("test_no"));
						test.setTestResult(rs.getString("test_result"));
						test.setUserNo(rs.getLong("user_no"));
						return test;
					}
		});
		if(vo.isEmpty())
			return null;
		return (TestResultVO)vo.get(0);  
	}
	@Override
	public TestResultVO findByNo(TestResultVO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestResultVO> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
