package com.zouensi.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.zouensi.dao.CategoryDao;
import com.zouensi.domain.Category;
import com.zouensi.factory.BeanFactory;
import com.zouensi.service.CategoryService;
/**
 * @author zouensi
 * @date 2017年7月13日
 * 描述:CategoryServlet实现类
 */
public class CategoryServiceImpl implements CategoryService{
	CategoryDao dao = BeanFactory.getBean(CategoryDao.class);
	@Override
	public String findCategorys(int pageSize, int pageNumber)
			throws SQLException {
		List<Category> categorys = dao.findCategorys(pageSize, pageNumber);
		long counts = dao.getCounts();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", counts);
		map.put("rows", categorys);
		return JSON.toJSONString(map);
	}
	@Override
	public int deleteByCid(String cid) throws SQLException {
		int status = dao.deleteByCid(cid);
		return status;
	}
	@Override
	public int addCategory(String cid, String cname) throws SQLException {
		int status = dao.addCatrgory(cid,cname);
		return status;
	}
	@Override
	public int updateCategory(String cid, String cname) throws SQLException {
		int status = dao.updateCategory(cid,cname);
		return status;
	}
}
