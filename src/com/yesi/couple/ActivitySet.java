package com.yesi.couple;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leeyeeun on 2016-02-01.
 */
public class ActivitySet extends Activity {
    static Typeface tf = null;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if(tf==null)
        {
            tf = Typeface.createFromAsset(getAssets(),"NanumPen.ttf");
        }
        ViewGroup  root = (ViewGroup)findViewById(android.R.id.content);
        setFont(root);
    }

    static public void setFont(ViewGroup root)
    {
        for(int i = 0;i<root.getChildCount();i++)
        {
            View child = root.getChildAt(i);
            if(child instanceof TextView)
            {
                ((TextView)child).setTypeface(tf);
                ((TextView)child).setTextSize(30);
            }
            else if(child instanceof ViewGroup)
            {
                setFont((ViewGroup) child);
            }
        }
    }
}
