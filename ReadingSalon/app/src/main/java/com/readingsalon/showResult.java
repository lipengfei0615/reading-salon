package com.readingsalon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.R;

public class showResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Intent intent=getIntent();
        Bundle bd=intent.getExtras();
        String d =bd.getString("string");
        TextView textView=(TextView) findViewById(R.id.txt_rd);
        textView.setText(d);


    }
}
