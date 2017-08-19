package com.example.guannan.elderlycare;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guannan on 19/8/2017.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftlayout;
        LinearLayout rightlayout;
        TextView receiveMsg;
        TextView sendMsg;

        public ViewHolder(View view){
            super(view);
            leftlayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightlayout = (LinearLayout) view.findViewById(R.id.right_layout);
            receiveMsg = (TextView) view.findViewById(R.id.receive_msg);
            sendMsg = (TextView) view.findViewById(R.id.send_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder  (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Msg msg = mMsgList.get(position);
        if(msg.getType() == Msg.TYPE_RECEIVED){
            holder.leftlayout.setVisibility(View.VISIBLE);
            holder.rightlayout.setVisibility(View.GONE);
            holder.receiveMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT){
            holder.leftlayout.setVisibility(View.GONE);
            holder.rightlayout.setVisibility(View.VISIBLE);
            holder.sendMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount(){
        return mMsgList.size();//写到这一步，最初的class报错才消失，报错说没有声明
    }
}
