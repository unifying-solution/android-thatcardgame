package com.unifiedclassroom.android.thatcardgame.obj.parsers;

import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public abstract class BaseParser extends DefaultHandler
{
	private Stack<String> tagStack;
	protected StringBuilder textNodeBuilder;
	
	protected BaseParser()
	{
		tagStack = new Stack<String>();
		textNodeBuilder = new StringBuilder();
	}
	
	protected void parse(InputSource input) throws IOException, SAXException, ParserConfigurationException
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		sp.parse(input, this);
	}
	
	public void characters(char[] ch, int start, int length)
	{
		textNodeBuilder.append(ch, start, length);
	}
	
	public final void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		tagStack.push(localName);
		startTag(uri, localName, qName, attributes);
	}
	
	public final void endElement(String uri, String localName, String qName) throws SAXException
	{
		if (tagStack.empty()) throw new SAXException("Unexpected tag. Got \"" + localName + "\"");
		String top = tagStack.pop();
		if (top.equals(localName)) throw new SAXException("Tag mismatch. Got \"" + localName + "\" but expected \"" + top + "\"");
		endTag(uri, localName, qName);
		textNodeBuilder.setLength(0);
	}
	
	public void endDocument() throws SAXException
	{
		if (!tagStack.empty()) throw new SAXException("Reached end of document with unclosed tag: \"" + tagStack.peek() + "\"");
	}
	
	protected String getText()
	{
		return textNodeBuilder.toString();
	}
	
	protected abstract void startTag(String uri, String tagName, String qualifiedName, Attributes attributes) throws SAXException;
	protected abstract void endTag(String uri, String tagName, String qualifiedName) throws SAXException;
	
}
