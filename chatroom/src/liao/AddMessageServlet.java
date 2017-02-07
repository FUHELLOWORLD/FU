package liao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import liao.service;
import liao.mod;

public class AddMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// ȡ���û���Ϣ
		HttpSession session = request.getSession(true);
		String userid = (String)session.getAttribute("userid");
		String sex = (String)session.getAttribute("sex");
		if(userid == null)
		{
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}
		System.out.println(sex);
		// ȡ������������Ϣ
		String info = request.getParameter("info");
		//info = new String(info.getBytes("8859_1"));
		
		// ȡ������������Ϣ
		ServletContext application = this.getServletContext();
		ArrayList<mod> allMessage = (ArrayList<mod>)application.getAttribute("allmod");
		
		// ������Ϣ����
		mod message = new mod(userid,sex,info);
		
		// ����ҵ�����
		service service = new service(allMessage);
		
		//service.Reverseallmod()����Ҫ��
		/*if(!(allMessage == null))
		{
			service.Reverseallmod();
		}*/
		// ����ҵ���߼�
		service.addmod(message);
		
		//service.Reverseallmod();
		// ������º����Ϣ
		application.setAttribute("allmod",service.getallmod());
		System.out.println(sex);
		System.out.println("��ת��content");
		// ת���������
		response.sendRedirect("content.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
