package com.example.guannan.elderlycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by guannan on 15/8/2017.
 */

public class ContactsAdapter extends ArrayAdapter<Contacts_list> {
    private int resourceId;
    public ContactsAdapter(Context context, int textViewResourceId, List<Contacts_list> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    //coonvertView用于将之前加载好的布局进行缓存，以便之后可以进行重用
    public View getView(int position, View convertView, ViewGroup parent) {
        Contacts_list contacts_list = getItem(position);//get current instance of Contacts_list

        View view;
        //如果convertView中为null，则使用LayoutInflater去加载布局，否则则直接对convertView进行重用，这样大大
        //提高了ListView的运行效率，在快速滚动的时候也能表现出更好的性能，不会再重复加载布局但仍然要findViewById获取控件实例
        //所以借助viewHolder
        ViewHolder viewHolder;

        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            //以下部分为加了viewHolder后加入
            viewHolder = new ViewHolder();
            viewHolder.contacts_image = (ImageView)view.findViewById(R.id.contacts_image);
            viewHolder.contacts_name = (TextView) view.findViewById(R.id.contacts_name);
            view.setTag(viewHolder);//将viewHolder存储在view中
            //到以上为止
        } else {
            view = convertView;
            //以下部分为加了viewHolder后加入
            viewHolder = (ViewHolder)view.getTag();//重新获取viewHolder
            //到以上为止

        }
        //以下两句是加了viewHolder后添加的
        viewHolder.contacts_name.setText(contacts_list.getName());
        viewHolder.contacts_image.setImageResource(contacts_list.getImageId());
        //加入viewHolder后省去
        /*
        ImageView contacts_image = (ImageView) view.findViewById(R.id.contacts_image);
        TextView contacts_name = (TextView) view.findViewById(R.id.contacts_name);
        contacts_image.setImageResource(contacts_list.getImageId());
        contacts_name.setText(contacts_list.getName());
        */
        //省到此为止

        //最原始，没添加convertView判断前的代码
        /*
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView contacts_image = (ImageView) view.findViewById(R.id.contacts_image);
        TextView contacts_name = (TextView) view.findViewById(R.id.contacts_name);
        contacts_image.setImageResource(contacts_list.getImageId());
        contacts_name.setText(contacts_list.getName());
        */
        return view;
    }

    class ViewHolder {
        ImageView contacts_image;
        TextView contacts_name;
    }
}
