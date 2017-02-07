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
		// 取出用户信息
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
		// 取出新增聊天信息
		String info = request.getParameter("info");
		//info = new String(info.getBytes("8859_1"));
		
		// 取出所有聊天信息
		ServletContext application = this.getServletContext();
		ArrayList<mod> allMessage = (ArrayList<mod>)application.getAttribute("allmod");
		
		// 创建消息对象
		mod message = new mod(userid,sex,info);
		
		// 创建业务对象
		service service = new service(allMessage);
		
		//service.Reverseallmod()不需要了
		/*if(!(allMessage == null))
		{
			service.Reverseallmod();
		}*/
		// 调用业务逻辑
		service.addmod(message);
		
		//service.Reverseallmod();
		// 保存更新后的信息
		application.setAttribute("allmod",service.getallmod());
		System.out.println(sex);
		System.out.println("跳转到content");
		// 转向聊天界面
		response.sendRedirect("content.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
