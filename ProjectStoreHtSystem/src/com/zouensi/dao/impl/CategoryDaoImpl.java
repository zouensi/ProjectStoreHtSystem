package com.zouensi.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zouensi.dao.CategoryDao;
import com.zouensi.domain.Category;
import com.zouensi.utils.QueryRunnerUtils;

public class CategoryDaoImpl implements CategoryDao{
	private QueryRunner qr = QueryRunnerUtils.getQueryRunnerWithDs();
	@Override
	public List<Category> findCategorys(int pageSize, int pageNumber)
			throws SQLException {
		int start = (pageSize-1)*pageNumber;
		String sql = "select * from category limit ?,?";
		List<Category> categorys = qr.query(sql, new BeanListHandler<Category>(Category.class),start,pageNumber);
		return categorys;
	}
	@Override
	public long getCounts() throws SQLException {
		String sql = "select count(*) from category";
		long count = (Long)qr.query(sql, new ScalarHandler());
		return count;
	}
	@Override
	public int deleteByCid(String cid) throws SQLException {
		String sql = "delete from category where cid=?";
		int status = qr.update(sql,cid);
		return status;
	}
	@Override
	public int addCatrgory(String cid, String cname) throws SQLException {
		String sql = "insert into category values(?,?)";
		int status = qr.update(sql,cid,cname);
		return status;
	}
	@Override
	public int updateCategory(String cid, String cname) throws SQLException {
		String sql = "update category set cname=? where cid=?";
		int status = qr.update(sql,cname,cid);
		return status;
	}
	
}
