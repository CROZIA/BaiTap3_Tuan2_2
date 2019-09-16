package com.example.baitap3_tuan2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> myList;
    ArrayAdapter<String> adapter;
    Button add;
    EditText item;
    TextView kq;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.buttonNhap);
        kq=(TextView)findViewById(R.id.textViewKq);
        item=(EditText)findViewById(R.id.editText_Item);
        lst=(ListView)findViewById(R.id.listView);
        myList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        lst.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(item.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg="Vị trí : "+i;
                msg+="    Giá trị : "+adapterView.getItemAtPosition(i).toString();
                kq.setText(msg);
            }
        });
    }

}
