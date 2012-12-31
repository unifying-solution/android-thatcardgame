package com.unifiedclassroom.android.thatcardgame.obj;

public class Card
{

	private String text;
	private long data;
	
	public Card()
	{
		text = "";
		data = 0l;
	}
	
	public void setText(String newValue)
	{
		text = newValue;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setData(long newValue)
	{
		data = newValue;
	}
	
	public long getData()
	{
		return data;
	}
	
}
