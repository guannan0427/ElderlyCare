package com.example.guannan.elderlycare;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contacts_list> contacts_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContacts();//初始化contacts类
        //实例化一个ContactsAdapter对象，第二个参数是对应的list内容部件xml，第三个是上边声明的private对象
        ContactsAdapter adapter = new ContactsAdapter(MainActivity.this,R.layout.contacts_item, contacts_list);
        //实例化一个listview，就是activity_main中的listview即我们要做的主list
        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(adapter);

        //添加点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Contacts_list contacts = contacts_list.get(position); //contacts里就保存了点击的那行的名字，用contacts.getName()
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("contact_name", contacts.getName());
                startActivity(intent);

            }
        });
    }

    private void initContacts(){
        for (int i = 0; i < 2; i++){
            Contacts_list ada = new Contacts_list("ada",R.drawable.a);
            contacts_list.add(ada);
            Contacts_list ada2 = new Contacts_list("ada2",R.drawable.a);
            contacts_list.add(ada2);
        }
    }
}
