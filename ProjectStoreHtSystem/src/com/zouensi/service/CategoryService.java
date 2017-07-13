package com.zouensi.service;

import java.sql.SQLException;

public interface CategoryService {
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws SQLException
	 */
	String findCategorys(int pageSize, int pageNumber) throws SQLException;

	int deleteByCid(String cid) throws SQLException;
	/**
	 * �������
	 * @param cid
	 * @param cname
	 * @return
	 * @throws SQLException 
	 */
	int addCategory(String cid, String cname) throws SQLException;
	/**
	 * ����category
	 * @param cid
	 * @param cname
	 * @return
	 * @throws SQLException 
	 */
	int updateCategory(String cid, String cname) throws SQLException;

}
