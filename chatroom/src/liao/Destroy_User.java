package liao;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class Destroy_User
{
	private HttpSession session;
	private ServletContext application;
	
	public Destroy_User(HttpSession session,ServletContext application)
	{
		this.application= application;
		this.session = session;
	}
	
	public boolean DelUser()
	{
		try
		{
			String user = "";
			//��ȡȫ�������û�
			//ServletContext application  = this.getServletContext();
			ArrayList<String> users = (ArrayList<String>)application.getAttribute("users");
			user = (String) session.getAttribute("userid");
			//����������
			Iterator<String> iter = users.iterator();
			//ɾ���Ѿ����ߵ��û�
			while (iter.hasNext()) 
			{
				   if (iter.next().equals(user)) 
				   {
				       iter.remove();
				   }
			}
			//�����û�
			application.setAttribute("users",users);
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
