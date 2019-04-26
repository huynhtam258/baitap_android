package com.thigiuaki.bai5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlatfFormAdapter extends ArrayAdapter<PlatfForm> {
    Context context;
    int layoutResourceId;
    List<PlatfForm> data;
    public PlatfFormAdapter(Context context, int resource, List data) {
        super(context, resource, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlatfFormHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new PlatfFormHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.ivPF);
            holder.txtTitle = (TextView)row.findViewById(R.id.tvPF);
            row.setTag(holder);
        }
        else
        {
            holder = (PlatfFormHolder)row.getTag();
        }
        PlatfForm pf = data.get(position);
        holder.txtTitle.setText(pf.title);
        holder.imgIcon.setImageResource(pf.icon);
        return row;
    }
    class PlatfFormHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }

}
