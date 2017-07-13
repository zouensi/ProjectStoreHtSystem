package com.zouensi.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zouensi.factory.BeanFactory;
import com.zouensi.service.CategoryService;
import com.zouensi.utils.UUIDUtils;

/**
 * 
 * @author zouensi
 * @date 2017年7月13日
 * 描述:商品servlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = BeanFactory
			.getBean(CategoryService.class);

	/**
	 * @see BaseServlet#BaseServlet()
	 */
	public CategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 分页查找分类信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String findCategorys(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int pageSize = Integer.parseInt(request.getParameter("page"));
		int pageNumber = Integer.parseInt(request.getParameter("rows"));
		String info = "";
		try {
			info = service.findCategorys(pageSize, pageNumber);
			response.getWriter().print(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据cid删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String deleteByCid(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cid = request.getParameter("cid");
		try {
			int status = service.deleteByCid(cid);
			response.getWriter().print("ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据cid删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String addCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cname = request.getParameter("cname");
		String cid = UUIDUtils.getUUID();
		try {
			int status = service.addCategory(cid,cname);
			if(status>0) {
				response.getWriter().print("ok");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String updateCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		try {
			int status = service.updateCategory(cid,cname);
			response.getWriter().print("ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
