package liao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mod 
{
	private String userid;
	private String info;
	private String time;
	private String sex;
	
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public mod(String userid,String sex,String info)
	{
		this.userid = userid;
		this.sex = sex;
		this.info = info;
		this.time = (new SimpleDateFormat("hh:mm:ss")).format(new Date());
		
	}
	public mod()
	{
		
	}
	
	public String getinfo()
	{
		return info;
	}
	
	public void setinfo(String info)
	{
		this.info = info;
	}
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public String getUserid()
	{
		return userid;
	}
	
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
}
