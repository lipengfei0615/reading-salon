package com.readingsalon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Contemporary extends AppCompatActivity{

   private static final int FAVORITE =111 ;
    private Context mContext;
    private ListView list_book;
    private MyAdapter<Book> myAdapter = null;
    private List<Book> mData = null;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu, menu);
       menu.add(1,FAVORITE,1,"Favorites");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case 111:
                Toast.makeText(getApplicationContext(), "Your Favorites", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public Intent getSupportParentActivityIntent() {
        finish();
        return null;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contemporary);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContext = Contemporary.this;
        init();


    }

    private void init() {


        list_book = (ListView) findViewById(R.id.contemporary);

        //数据初始化

        mData = new ArrayList<Book>();

        mData.add(new Book("TheCartel"));
        mData.add(new Book("TheKiteRunner"));
        mData.add(new Book("TheNightCircus"));


        //Adapter初始化
        myAdapter = new MyAdapter<Book>((ArrayList) mData,R.layout.listitem) {
            @Override
            public void bindView(ViewHolder holder, Book obj) {
                holder.setText(R.id.txt_tv,obj.getbName());
            }
        };

        //ListView设置下Adapter：
        list_book.setAdapter(myAdapter);
        list_book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =null;
                InputStream inputStream=null;
                String string=null;
                Bundle bd=new Bundle();
                switch(position) {
                    case 0:
                        inputStream = getResources().openRawResource(R.raw.a);
                        string = TxtReader.getString(inputStream);
                        intent=new Intent(mContext,showResult.class);
                        bd.putString("string",string);
                        intent.putExtras(bd);
                        startActivity(intent);
                        break;
                    case 1:
                        inputStream = getResources().openRawResource(R.raw.b);
                        string = TxtReader.getString(inputStream);
                        intent=new Intent(mContext,showResult.class);
                        bd.putString("string",string);
                        intent.putExtras(bd);
                        startActivity(intent);
                        break;
                    case 2:
                        inputStream = getResources().openRawResource(R.raw.c);
                        string = TxtReader.getString(inputStream);
                        intent=new Intent(mContext,showResult.class);
                        bd.putString("string",string);
                        intent.putExtras(bd);
                        startActivity(intent);
                        break;

                    default: break;
                }

            }
        });
    }

}
