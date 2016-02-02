package com.yesi.couple;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leeyeeun on 2016-02-01.
 */
public class ArrayAdapterSet<T> extends ArrayAdapter {

    private Context context;
    private int textViewResourceId;
    private List<String> list;
    private Typeface tf;

    public ArrayAdapterSet(Context context, int textViewResourceId, List<String> list)
    {
        super(context,textViewResourceId,list);

        tf = Typeface.createFromAsset(context.getAssets(),"NanumPen.ttf");
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v ==null)
        {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=vi.inflate(textViewResourceId,null);
        }

        TextView textView = (TextView)v.findViewById(R.id.textView);

        if(list.get(position)!=null)
        {
            textView.setText(list.get(position));
            textView.setTypeface(tf);
        }

        return v;
    }
}
