package com.zouensi.dao;

import java.sql.SQLException;
import java.util.List;

import com.zouensi.domain.Category;

public interface CategoryDao {
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws SQLException
	 */
	List<Category> findCategorys(int pageSize, int pageNumber) throws SQLException;
	
	/**
	 * ��ȡ���������
	 * @return
	 * @throws SQLException
	 */
	long getCounts() throws SQLException;

	int deleteByCid(String cid) throws SQLException;

	int addCatrgory(String cid, String cname) throws SQLException;
	/**
	 * ���·�����Ϣ
	 * @param cid
	 * @param cname
	 * @return
	 * @throws SQLException 
	 */
	int updateCategory(String cid, String cname) throws SQLException;

}
