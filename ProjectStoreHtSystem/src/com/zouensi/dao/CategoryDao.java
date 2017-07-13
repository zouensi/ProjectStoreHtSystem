package com.zouensi.dao;

import java.sql.SQLException;
import java.util.List;

import com.zouensi.domain.Category;

public interface CategoryDao {
	/**
	 * 分页查询分类信息
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws SQLException
	 */
	List<Category> findCategorys(int pageSize, int pageNumber) throws SQLException;
	
	/**
	 * 获取分类的数量
	 * @return
	 * @throws SQLException
	 */
	long getCounts() throws SQLException;

	int deleteByCid(String cid) throws SQLException;

	int addCatrgory(String cid, String cname) throws SQLException;
	/**
	 * 更新分类信息
	 * @param cid
	 * @param cname
	 * @return
	 * @throws SQLException 
	 */
	int updateCategory(String cid, String cname) throws SQLException;

}
