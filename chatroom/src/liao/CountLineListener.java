package liao;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;   
import javax.servlet.http.HttpSessionListener; 

public class CountLineListener implements HttpSessionListener
{
	     // ����sessionʱ����   
	     public void sessionCreated(HttpSessionEvent event) 
	     {   
	         System.out.println("����session......");   
	         ServletContext context = event.getSession().getServletContext();   
	         Integer count=(Integer)context.getAttribute("count");
	         if(count==null){   
	             count=new Integer(1);   
	         }else{   
	             int co = count.intValue( );   
	             count= new Integer(co+1);   
	         }   
	         System.out.println("��ǰ�û�������"+count);   
	         context.setAttribute("count", count);//��������   
	     }  
	     
	     //����sessionʱ����   
	     public void sessionDestroyed(HttpSessionEvent event) {   
	         System.out.println("����session......");   
	         ServletContext context=event.getSession().getServletContext();
	         //ɾ�����߶���
	         Destroy_User user = new Destroy_User(event.getSession(),context);
	         user.DelUser();
	         //HttpSession session = event.getSession();
	         //System.out.println(session.getAttribute("userid"));
	         Integer count=(Integer)context.getAttribute("count");   
	         int co=count.intValue();   
	         count=new Integer(co-1);   
	         context.setAttribute("count", count);   
	         System.out.println("��ǰ�û�������"+count);   
	    }   
}
