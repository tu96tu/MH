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
import com.tutu.vo.ArticleCollectionVO;
import com.tutu.vo.ArticleInfoVO;
import com.tutu.vo.UserInfoVO;
@Repository
public class ArticleInfoDao implements DAOSupper<ArticleInfoVO>{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Override
	public void add(ArticleInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into article_info(num,article_title,article_author,article_content,article_date,article_pic) values(?,?,?,?,?,?)",
				t.getNum(),t.getArticleTitle(),t.getArticleAuthor(),t.getArticleContent(),t.getArticleDate(),t.getArticlePic());
	}

	@Override
	public void delete(ArticleInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from article_info where article_no=?",t.getArticleNo());
	}

	@Override
	public void modify(ArticleInfoVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update article_info set num=?,article_title=?,article_author=?,article_content=?,article_date=?,article_pic=? where article_no=?",
				t.getNum(),t.getArticleTitle(),t.getArticleAuthor(),t.getArticleContent(),t.getArticleDate(),t.getArticlePic(),t.getArticleNo());
	}
	/**
	 * 文章收藏
	 * @param t
	 * @param k
	 * @param date
	 */
	public void collect(ArticleInfoVO t,UserInfoVO k,String date){
		this.jdbcTemplate.update("insert into collection_info(user_no,article_no,coll_date) values(?,?,?)",k.getUserNo(),t.getArticleNo(),date);
	}
	/**
	 * 取消收藏
	 * @param t
	 */
	public void delete(ArticleCollectionVO t) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from collection_info where coll_no=?",t.getCollNo());
	}
	@Override
	public List<ArticleInfoVO> findAll() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query("select * from article_info",
				new RowMapper<ArticleInfoVO>(){

			@Override
			public ArticleInfoVO mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				return load(rs);
			}
			
		});
	}

	/**
	 * 按用户id、文章id搜索对应的收藏信息
	 * @param t
	 * @param k
	 * @return
	 */
	public ArticleCollectionVO findCollect(ArticleInfoVO t,UserInfoVO k) {
		// TODO Auto-generated method stub
		String sql="select * from collection_info where article_no=? and user_no =?";
		Object[] args = new Object[]{t.getArticleNo(),k.getUserNo()}; 
		List<ArticleCollectionVO> vo = this.jdbcTemplate.query(sql, args,
				new RowMapper<ArticleCollectionVO>(){
					@Override
					public ArticleCollectionVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						ArticleCollectionVO vo1 = new ArticleCollectionVO();
						vo1.setArticleNo(rs.getLong("article_no"));
						vo1.setCollDate(rs.getString("coll_date"));
						vo1.setCollNo(rs.getLong("coll_no"));
						vo1.setUserNo(rs.getLong("user_no"));
						return vo1;
						
					}
		});
		if(vo.isEmpty())
			return null;
		return (ArticleCollectionVO)vo.get(0); 
	}
	/**
	 * 搜索当前用户的所有收藏记录
	 * @return
	 */
	public List<ArticleCollectionVO> findCollectionAll(UserInfoVO t) {
		// TODO Auto-generated method stub\
		Object[] args = new Object[]{t.getUserNo()}; 
		return this.jdbcTemplate.query("select * from collection_info where user_no=?",args,
				new RowMapper<ArticleCollectionVO>(){

			@Override
			public ArticleCollectionVO mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				ArticleCollectionVO vo = new ArticleCollectionVO();
				vo.setArticleNo(rs.getLong("article_no"));
				vo.setCollDate(rs.getString("coll_date"));
				vo.setCollNo(rs.getLong("coll_no"));
				vo.setUserNo(rs.getLong("user_no"));
				return vo;
			}
			
		});
	}
	/**
	 * 分页查找所有文章
	 * @param page
	 * @param rowMax
	 * @return
	 */
	public List<ArticleInfoVO> findAll(int page, int rowMax) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from article_info order by article_no  limit ?,? ",obj,
				new RowMapper<ArticleInfoVO>(){

					@Override
					public ArticleInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long count(){
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from article_info");
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}

	@Override
	public ArticleInfoVO findByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleInfoVO findByNo(ArticleInfoVO t) {
		// TODO Auto-generated method stub
		String sql="select * from article_info where article_no=?";
		Object[] args = new Object[]{t.getArticleNo()}; 
		List<ArticleInfoVO> vo = this.jdbcTemplate.query(sql, args,
				new RowMapper<ArticleInfoVO>(){
					@Override
					public ArticleInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}	
		});
		if(vo.isEmpty())
			return null;
		return (ArticleInfoVO)vo.get(0); 
	}

	@Override
	public List<ArticleInfoVO> search(String str) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%","%"+str+"%"};
		return  this.jdbcTemplate.query("select * from article_info where article_title like ? or article_author like ? or article_no like ? ",obj,
				new RowMapper<ArticleInfoVO>(){

					@Override
					public ArticleInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	public List<ArticleInfoVO> search(String str,int page, int rowMax) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%",(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from article_info where article_title like ? or article_author like ? order by article_no desc limit ?,? ",obj,
				new RowMapper<ArticleInfoVO>(){

					@Override
					public ArticleInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}

	public long searchCount(String str){
		Object[] obj = new Object[]{"%"+str+"%","%"+str+"%"};
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from article_info where article_title like ? or article_author like ?",obj);
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}
	
	public List<ArticleInfoVO> search(int num,int page, int rowMax) {
		// TODO Auto-generated method stub
		Object[] obj = new Object[]{num,(page - 1) * rowMax,rowMax};
		return  this.jdbcTemplate.query("select * from article_info where num=?  order by article_no desc limit ?,? ",obj,
				new RowMapper<ArticleInfoVO>(){

					@Override
					public ArticleInfoVO mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						return load(rs);
					}
			
		});
	}
	
	public long searchCount(int num){
		Object[] obj = new Object[]{num};
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from article_info where num=?",obj);
		if (rs.next()) {
			return rs.getLong(1);
		} else {
			return 0l;
		}   
	}
	private ArticleInfoVO load(ResultSet rs) throws SQLException{
		ArticleInfoVO vo = new ArticleInfoVO();
		vo.setArticleNo(rs.getLong("article_no"));
		vo.setNum(rs.getInt("num"));
		vo.setArticleTitle(rs.getString("article_title"));
		vo.setArticleAuthor(rs.getString("article_author"));
		vo.setArticleContent(rs.getString("article_content"));
		vo.setArticleDate(rs.getString("article_date"));
		vo.setArticlePic(rs.getString("article_pic"));
		return vo;
	}
}
