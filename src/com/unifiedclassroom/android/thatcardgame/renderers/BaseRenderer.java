package com.unifiedclassroom.android.thatcardgame.renderers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.unifiedclassroom.android.thatcardgame.R;
import com.unifiedclassroom.android.thatcardgame.obj.Card;

public abstract class BaseRenderer
{
	
	private int width;
	private int height;
	
	public BaseRenderer(Context context)
	{
		Resources res = context.getResources();
		width = Math.round(res.getDimension(R.dimen.CardRenderGridUnit) * res.getInteger(R.plurals.CardRenderGridWidth));
		height = Math.round(res.getDimension(R.dimen.CardRenderGridUnit) * res.getInteger(R.plurals.CardRenderGridHeight));
	}
	
	public Bitmap render(Card card)
	{
		Bitmap bm = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas c = new Canvas(bm);
		renderCard(c, card);
		return bm;
	}
	
	protected abstract void renderCard(Canvas canvas, Card card);
	
}
