package com.example.guannan.elderlycare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guannan on 15/8/2017.
 */

public class SecondActivity extends AppCompatActivity {
    private List<Second_list> second_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //获取上一页点击的contact 名字
        Intent intent = getIntent();
        String contact_name = intent.getStringExtra("contact_name");


        initSecondList(contact_name);
        SecondItemAdapter adapter = new SecondItemAdapter(SecondActivity.this,R.layout.secondlist_item, second_list);
        ListView listView = (ListView) findViewById(R.id.second_list);
        listView.setAdapter(adapter);


    }

    private void initSecondList(String contact_name){
        Second_list ada = new Second_list(contact_name,R.drawable.a);
        second_list.add(ada);
        for (int i = 0; i < 2; i++){
            Second_list other = new Second_list("other", R.drawable.a);
            second_list.add(other);

        }
    }
}
