package com.example.bubble422;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 点击导航栏对话icon进入Activity
 */
public class Activity_huanhze_yuyin extends AppCompatActivity {
    /*private RecyclerView msgRecyclerView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<>();*/
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private Button back;
    private Button next;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<Msg>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        initMsgs();
        adapter =  new MsgAdapter(this,R.layout.chat_item,msgList);
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        back=(Button)findViewById(R.id.back) ;
        next=(Button)findViewById(R.id.next) ;
        msgListView = (ListView)findViewById(R.id.list_view);
        msgListView.setAdapter((ListAdapter) adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");

                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]content=new String[5];
                content[0] ="Do you want a cup of tea?";
                content[1] ="How about doing sports?";
                content[2] ="How about listening to music?";
                content[3] ="Be free to tell me what you think.";
                content[4] ="Hope you will be happy again!";
                Random r=new Random();
                int num=r.nextInt(5);
                String contents=content[num];
                Msg msg = new Msg(contents,Msg.TYPE_RECEIVED);
                msgList.add(msg);
                adapter.notifyDataSetChanged();
                msgListView.setSelection(msgList.size());

            }
        });
    }
    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }



}
