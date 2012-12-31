package com.unifiedclassroom.android.thatcardgame.obj.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import com.unifiedclassroom.android.thatcardgame.obj.Game;

public class GameParser extends ObjectParser<Game>
{

	private Game mGame = new Game();
	
	@Override
	protected void startTag(String uri, String tagName, String qualifiedName, Attributes attributes) throws SAXException
	{
		// TODO Check tags and build a Game object
	}

	@Override
	protected void endTag(String uri, String tagName, String qualifiedName) throws SAXException
	{
		
	}

	@Override
	protected Game getObject()
	{
		return mGame;
	}	
	
}
