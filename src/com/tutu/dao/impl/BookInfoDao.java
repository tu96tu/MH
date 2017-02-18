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
import com.tutu.vo.BookInfoVO;
import com.tutu.vo.UserInfoVO;
@Repository
public class BookInfoDao implements DAOSupper<BookInfoVO>{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Override
	public void add(BookInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into book_info (num,book_name,book_author,book_age1,book_age2,book_intrd,book_grade,book_pic) values(?,?,?,?,?,?,?,?)",
				t.getNum(),t.getBookName(),t.getBookAuthor(),t.getBookAge1(),t.getBookAge2(),t.getBookIntrd(),t.getBookGrade(),t.getBookPic());
	}

	@Override
	public void delete(BookInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from book_info where book_no =?",t.getBookNo());
	}

	@Override
	public void modify(BookInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update book_info set num=?,book_name=?,book_author=?,book_age1=?,book_age2=?,book_intrd=?,book_grade=?,book_pic=? where book_no=?",
				t.getNum(),t.getBookName(),t.getBookAuthor(),t.getBookAge1(),t.getBookAge2(),t.getBookIntrd(),t.getBookGrade(),t.getBookPic(),t.getBookNo());
	}

	@Override
	public List<BookInfoVO> findAll() {
		// TODO Auto-generated method stub
		return  this.jdbcTemplate.query("select * from book_info ",
				new RowMapper<BookInfoVO>(){

					@Override
					public BookInfoVO mapRow(ResultSet rs, int index) 
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public List<BookInfoVO> findAll(int page, int rowMax) {
		Object[] args = new Object[] {(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from book_info order by book_no desc limit ?,?",args,
				new RowMapper<BookInfoVO>(){

					@Override
					public BookInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long count(){
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from book_info");
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}

	@Override
	public BookInfoVO findByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookInfoVO findByNo(BookInfoVO t) {
		// TODO Auto-generated method stub
		String sql ="select * from book_info where book_no=?";
		Object[] args = new Object[] {t.getBookNo()};
		List<BookInfoVO> vo =  this.jdbcTemplate.query(sql,args,new RowMapper<BookInfoVO>(){
					@Override
					public BookInfoVO mapRow(ResultSet rs, int index)throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
		if(vo.isEmpty())
			return null;
		return (BookInfoVO)vo.get(0); 
	}

	@Override
	public List<BookInfoVO> search(String str) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%","%"+str+"%"};
		return  this.jdbcTemplate.query("select * from book_info where book_no like ? or book_name like ? or book_author like ? ",obj,
				new RowMapper<BookInfoVO>(){

					@Override
					public BookInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public List<BookInfoVO> recommend(UserInfoVO t) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM (select * from book_info where ((select num from user_info where user_no = ?) = num or (select user_age from user_info where user_no = ?) BETWEEN book_age1 AND book_age2)) A ORDER BY RAND() LIMIT 5";
		Object[] obj = new Object[]{t.getUserNo(),t.getUserNo()};
		return  this.jdbcTemplate.query(sql,obj,
				new RowMapper<BookInfoVO>(){

					@Override
					public BookInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public List<BookInfoVO> recommend() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM  book_info  ORDER BY RAND() LIMIT 5";
		return  this.jdbcTemplate.query(sql,
				new RowMapper<BookInfoVO>(){

					@Override
					public BookInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}	
		});
	}
	
	private BookInfoVO load(ResultSet rs)throws SQLException{
		BookInfoVO  vo = new BookInfoVO();
		vo.setBookNo(rs.getLong("book_no"));
		vo.setNum(rs.getInt("num"));
		vo.setBookName(rs.getString("book_name"));
		vo.setBookAuthor(rs.getString("book_author"));
		vo.setBookAge1(rs.getInt("book_age1"));
		vo.setBookAge2(rs.getInt("book_age2"));
		vo.setBookIntrd(rs.getString("book_intrd"));
		vo.setBookGrade(rs.getString("book_grade"));
		vo.setBookPic(rs.getString("book_pic"));
		return vo;
	}
}
