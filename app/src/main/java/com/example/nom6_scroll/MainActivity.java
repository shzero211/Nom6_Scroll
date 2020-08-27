package com.example.nom6_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //데이터 준비 첫번째는 평볌한 데이터,2번째는 새로운 adapter를위한 데이터
//        1.ArrayList<String> data =new ArrayList<>();
//        for(int i=0;i<30;i++){
//            data.add("data"+i);
//        }

        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("서울","26도","비"));
        data.add(new Weather("안양","24도","구름"));
        data.add(new Weather("부산","29도","구름"));
        data.add(new Weather("인천","23도","맑음"));
        data.add(new Weather("대구","28도","비"));
        data.add(new Weather("용인","25도","비"));



        //view에 데이터를 삽입을 도와주는 adapter 첫번째는평번한 adapter,2번째는 MyFirstAdapter를 이용하여 만든 adapter

//        1.ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        MyFirstAdapter adapter=new MyFirstAdapter(data);

    //뷰
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"번쨰 아이템 선택",Toast.LENGTH_SHORT).show();
            }
        });
    }
}