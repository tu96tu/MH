package com.tutu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import com.tutu.dao.DAOSupper;
import com.tutu.vo.UserInfoVO;
@Repository
public class UserInfoDao implements DAOSupper<UserInfoVO>{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(UserInfoVO t) {
		// TODO Auto-generated method stub
		
		this.jdbcTemplate.update("insert into user_info(user_name,user_pwd,user_real_name,user_sex,user_age,user_tel) values(?,?,?,?,?,?)",
				t.getUserName(),t.getUserPwd(),t.getUserRealName(),t.isUserSex(),t.getUserAge(),t.getUserTel());
		
	}

	@Override
	public void delete(UserInfoVO t) {
		// TODO Auto-generated method stub
		
		this.jdbcTemplate.update("delete from user_info where user_no = ?",t.getUserNo());
		
	}

	@Override
	public void modify(UserInfoVO t) {
		// TODO Auto-generated method stub

		this.jdbcTemplate.update("update user_info set user_name=?,user_pwd=?,user_real_name=?,user_sex=?,user_age=?,user_tel=?,user_role=?,user_lock=? where user_no=?",
				t.getUserName(),t.getUserPwd(),t.getUserRealName(),t.isUserSex(),t.getUserAge(),t.getUserTel(),t.isUserRole(),t.isUserLock(),t.getUserNo());

	}

	@Override
	public List<UserInfoVO> findAll() {
		// TODO Auto-generated method stub
		return  this.jdbcTemplate.query("select * from user_info ",
				new RowMapper<UserInfoVO>(){

					@Override
					public UserInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	public List<UserInfoVO> findAll(int page, int rowMax) {
		Object[] args = new Object[] {(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from user_info order by user_no desc limit ?,?",args,
				new RowMapper<UserInfoVO>(){

					@Override
					public UserInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long count(){
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from user_info");
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}

	public UserInfoVO findByName(String userName) {
		// TODO Auto-generated method stub
		String sql ="select * from user_info where user_name=?";
		Object[] args = new Object[] {userName};
		//System.out.println(args[0]);
		List<UserInfoVO> vo =  this.jdbcTemplate.query(sql,args,new RowMapper<UserInfoVO>(){
					@Override
					public UserInfoVO mapRow(ResultSet rs, int index)throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
		});
		if(vo.isEmpty())
			return null;
		return (UserInfoVO)vo.get(0);  
	}
	
	@Override
	public List<UserInfoVO> search(String str) {
		// TODO Auto-generated method stub
		//System.out.println(str);
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%","%"+str+"%"};
		return  this.jdbcTemplate.query("select * from user_info where user_name like ? or user_real_name like ? or user_tel like ? ",obj,
				new RowMapper<UserInfoVO>(){

					@Override
					public UserInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
		
	}

	@Override
	public UserInfoVO findByNo(UserInfoVO t) {
		// TODO Auto-generated method stub
		String sql ="select * from user_info where user_no=?";
		Object[] args = new Object[] {t.getUserNo()};
		List<UserInfoVO> vo =  this.jdbcTemplate.query(sql,args,new RowMapper<UserInfoVO>(){
					@Override
					public UserInfoVO mapRow(ResultSet rs, int index)throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
		if(vo.isEmpty())
			return null;
		return (UserInfoVO)vo.get(0);   
	}
	
	
	private UserInfoVO load(ResultSet rs) throws SQLException{
		UserInfoVO vo = new UserInfoVO();
		vo.setNum(rs.getInt("num"));
		vo.setUserNo(rs.getLong("user_no"));
		vo.setUserName(rs.getString("user_name"));
		vo.setUserPwd(rs.getString("user_pwd"));
		vo.setUserRealName(rs.getString("user_real_name"));
		vo.setUserSex(rs.getBoolean("user_sex"));
		vo.setUserAge(rs.getInt("user_age"));
		vo.setUserTel(rs.getLong("user_tel"));
		vo.setUserRole(rs.getBoolean("user_role"));
		vo.setUserLock(rs.getBoolean("user_lock"));
		return vo;
		
	}


}
