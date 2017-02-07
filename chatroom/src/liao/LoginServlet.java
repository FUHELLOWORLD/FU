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

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("gb2312");
		
		// 获取用户输入信息
		String userid = request.getParameter("userid");
		//userid = new String(userid.getBytes("8859_1"));
		String sex = request.getParameter("sex");
		//sex = new String(sex.getBytes("8859_1"));
		
		// 获取application对象
		ServletContext application  = this.getServletContext();
		// 获取用户
		ArrayList<String> users = (ArrayList<String>)application.getAttribute("users");
		
		if(users!=null && users.contains(userid))
		{
			request.setAttribute("errorinfo","用户"+userid+"已经存在");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}else
		{
			if(users == null)
			{
				users = new ArrayList<String>();
			}
			users.add(userid);
			application.setAttribute("users",users);
			HttpSession session = request.getSession(true);
			session.setAttribute("userid",userid);
			session.setAttribute("sex",sex);
			System.out.println(session.getAttribute("userid"));
			System.out.println(session.getAttribute("sex"));
			response.sendRedirect("chat.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
