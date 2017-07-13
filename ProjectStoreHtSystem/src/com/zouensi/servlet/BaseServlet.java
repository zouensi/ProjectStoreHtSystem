package com.zouensi.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zouensi.utils.Utils;

/**
 * 
 * @author zouensi
 * @date 2017��7��6��
 * ����:servlet����
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BaseServlet() {
        super();
    }

    /**
     * ���÷������ÿ��servlet�Ķ�Ӧ����
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҪ���õķ���������
		String name = request.getParameter("method");
		if(Utils.isEmpty(name)) {
			defaultMethod(request, response);
		}else {
			//˭���ö�����˭��������þ��������ֽ������
			Class<? extends BaseServlet> clazz = this.getClass();
			try {
				//��ȡ��������
				Method method = clazz.getMethod(name, HttpServletRequest.class,HttpServletResponse.class);
				//���÷���ͬʱ��ȡ����ֵ,����null��������ת��
				Object obj = method.invoke(this, request,response);//�����������������Ҫ�þ���ҵ�񷽷����е��ô���
				if(obj!=null) {
					request.getRequestDispatcher(obj.toString()).forward(request, response);
				}
			} catch (Exception e) {
				showInfo(request,response,"�ף��������");
				e.printStackTrace();
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * ����ҳ��ͳһ��ת����
	 * @param request
	 * @param msg
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void showInfo(HttpServletRequest request, HttpServletResponse response,String msg) throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("jsp/info.jsp").forward(request, response);
	}
	
	public void defaultMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
	}

}
