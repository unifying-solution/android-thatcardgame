package com.unifiedclassroom.android.thatcardgame.obj.parsers;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.unifiedclassroom.android.thatcardgame.obj.XmlObject;


public abstract class ListParser<T extends XmlObject> extends BaseParser
{

	protected abstract List<T> getObjectList();

	public List<T> parseObjectList(InputSource input) throws IOException, SAXException, ParserConfigurationException
	{
		parse(input);
		return getObjectList();
	}
	
}
