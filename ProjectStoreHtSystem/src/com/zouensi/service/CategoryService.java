package com.zouensi.service;

import java.sql.SQLException;

public interface CategoryService {
	/**
	 * 分页查询分类信息
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws SQLException
	 */
	String findCategorys(int pageSize, int pageNumber) throws SQLException;

	int deleteByCid(String cid) throws SQLException;
	/**
	 * 添加类型
	 * @param cid
	 * @param cname
	 * @return
	 * @throws SQLException 
	 */
	int addCategory(String cid, String cname) throws SQLException;
	/**
	 * 更新category
	 * @param cid
	 * @param cname
	 * @return
	 * @throws SQLException 
	 */
	int updateCategory(String cid, String cname) throws SQLException;

}
