package com.example.guannan.elderlycare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guannan on 19/8/2017.
 */

public class MsgActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle sanvedInstanceState){
        super.onCreate(sanvedInstanceState);
        setContentView(R.layout.chat_main);
        initMsgs();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }

            }
        });
    }

    private void initMsgs(){
        Msg msg1 = new Msg("小宝，早安", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("哥哥醒啦~~早安呢", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("嘿嘿", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
        Msg msg4 = new Msg("还有没有奶奶喝了呀？有的话去吃点早饭呢，啦啦啦啦啦啦啦啦啦啦啦啦", Msg.TYPE_SENT);
        msgList.add(msg4);
        Msg msg5 = new Msg("今天周六啦，是不是要去超市了呀？", Msg.TYPE_SENT);
        msgList.add(msg5);
        Msg msg6 = new Msg("没有牛奶了呢", Msg.TYPE_RECEIVED);
        msgList.add(msg6);
        Msg msg7 = new Msg("可能要去吧，看他们的", Msg.TYPE_RECEIVED);
        msgList.add(msg7);
        Msg msg8 = new Msg("可能要去吧，看他们的", Msg.TYPE_RECEIVED);
        msgList.add(msg8);
        Msg msg9 = new Msg("可能要去吧，看他们的", Msg.TYPE_RECEIVED);
        msgList.add(msg9);

    }
}
