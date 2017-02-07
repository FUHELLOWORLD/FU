package liao;

import java.util.*;
import liao.mod;

public class service 
{
	private ArrayList<mod> allmod;
	public service(ArrayList<mod> allmod)
	{
		this.allmod = allmod;
	}
	
	public ArrayList<mod> getallmod()
	{
		return allmod;
	}
	
	public void addmod (mod Mod)
	{
		if(allmod == null)
		{
			allmod = new ArrayList<mod>();
		}
		int size = allmod.size();
		allmod.add(size,Mod);
	}
	
	//Reverseallmod·ÏÆú
	public void Reverseallmod()
	{
		mod ling = null;
		int y = allmod.size();
		for(int i = 0; i<y/2;i++)
		{
			ling = allmod.get(y-1);
			allmod.set(y-1, allmod.get(i));
			allmod.set(i, ling);
			y--;
		}
	}
}
