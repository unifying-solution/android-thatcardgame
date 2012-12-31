package com.unifiedclassroom.android.thatcardgame.obj.parsers;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.unifiedclassroom.android.thatcardgame.obj.XmlObject;

public abstract class ObjectParser<T extends XmlObject> extends BaseParser
{
	protected abstract T getObject();

	public T parseObject(InputSource input) throws IOException, SAXException, ParserConfigurationException
	{
		parse(input);
		return getObject();
	}
	
	
}
