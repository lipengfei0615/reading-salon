package com.readingsalon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private int[] image = {R.drawable.contemporary, R.drawable.crime, R.drawable.detective,
            R.drawable.fairytale, R.drawable.humor, R.drawable.mythology, R.drawable.romance,
            R.drawable.science, R.drawable.thrillers};
    private String[] text = {"Contemporary", "Crime", "Detective", " FairyTale", "Humor", "Mythology", "Romance", "Science", "Thrillers"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setTitle("Reading Salon");
        getSupportActionBar().setIcon(R.mipmap.read);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        GridView gridview = (GridView) findViewById(R.id.GridView);
        ArrayList<HashMap<String, Object>> imagelist = new ArrayList<HashMap<String, Object>>();
        // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
        // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
        for (int i = 0; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", image[i]);
            map.put("text", text[i]);
            imagelist.add(map);
        }
        // 使用simpleAdapter封装数据，将图片显示出来
        // 参数一是当前上下文Context对象
        // 参数二是图片数据列表，要显示数据都在其中
        // 参数三是界面的XML文件，注意，不是整体界面，而是要显示在GridView中的单个Item的界面XML
        // 参数四是动态数组中与map中图片对应的项，也就是map中存储进去的相对应于图片value的key
        // 参数五是单个Item界面XML中的图片ID
        SimpleAdapter imageAdapter = new SimpleAdapter(this, imagelist,
                R.layout.items, new String[]{"image", "text"}, new int[]{
                R.id.image, R.id.title});
        gridview.setAdapter(imageAdapter);// 设置GridView的适配器为新建的simpleAdapter
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =null;
                String message=null;
                String []array1=null;
                switch(position) {
                   case 0:
//                      message="?contemporary?";
//                       try {
//                           array1=sendMessage(message);
//                       } catch (IOException e) {
//                           e.printStackTrace();
//                       } catch (ClassNotFoundException e) {
//                           e.printStackTrace();
//                       }
                       intent=new Intent(MainActivity.this, Contemporary.class);
//                       Bundle bd= new Bundle();
//                       bd.putStringArray("array1", array1);
//                       intent.putExtras(bd);
                       startActivity(intent);
                        break;
                   case 1:
                       intent=new Intent(MainActivity.this, Crime.class);
                       startActivity(intent);
                       break;
                   case 2:
                       intent=new Intent(MainActivity.this, Detective.class);
                       startActivity(intent);
                        break;
                   case 3:
                       intent=new Intent(MainActivity.this, FairyTale.class);
                       startActivity(intent);
                        break;
                   case 4:
                       intent=new Intent(MainActivity.this, Humor.class);
                       startActivity(intent);
                        break;
                   case 5:
                       intent=new Intent(MainActivity.this, Mythology.class);
                       startActivity(intent);
                        break;
                   case 6:
                       intent=new Intent(MainActivity.this, Romance.class);
                       startActivity(intent);
                        break;
                   case 7:
                       intent=new Intent(MainActivity.this, Science.class);
                       startActivity(intent);
                        break;
                   case 8:
                       intent=new Intent(MainActivity.this, Thrillers.class);
                       startActivity(intent);
                        break;
                   default: break;
               }

            }
        });

    }
    public String[] sendMessage(String message) throws UnknownHostException, IOException, ClassNotFoundException {
        String host = "127.0.0.1";
        int port = 11222;
        Socket socket = new Socket(host, port);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(message);
        BufferedReader breader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String re = breader.readLine();

        String[] sArray = re.split("$");
        return sArray;

    }
}







