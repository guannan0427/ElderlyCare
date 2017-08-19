package com.example.guannan.elderlycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guannan on 15/8/2017.
 */

public class SecondItemAdapter extends ArrayAdapter<Second_list> {
    private int resourceId;
    public SecondItemAdapter(Context context, int textViewResourceId, List<Second_list> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Second_list second_list = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.secondItem_image = (ImageView)view.findViewById(R.id.secondItem_image);
            viewHolder.secondItem_name = (TextView)view.findViewById(R.id.secondItem_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.secondItem_name.setText(second_list.getName());
        viewHolder.secondItem_image.setImageResource(second_list.getImageId());

        return view;
    }

    class ViewHolder{
        ImageView secondItem_image;
        TextView secondItem_name;
    }
}
