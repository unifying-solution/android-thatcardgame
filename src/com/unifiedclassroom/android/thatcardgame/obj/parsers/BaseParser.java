package com.unifiedclassroom.android.thatcardgame.obj.parsers;

import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public abstract class BaseParser extends DefaultHandler
{
	protected Stack<String> tagStack;
	private StringBuilder textNodeBuilder;
	
	protected BaseParser()
	{
		tagStack = new Stack<String>();
		textNodeBuilder = new StringBuilder();
	}
	
	public void characters(char[] ch, int start, int length)
	{
		textNodeBuilder.append(ch, start, length);
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		
	}
	
	public void endElement(String uri, String locaName, String qName)
	{
		
	}
	
}
