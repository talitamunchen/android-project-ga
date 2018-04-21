package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HistActivity extends AppCompatActivity {

    private LinearLayout btnBack;
    private LinearLayout btnHist;
    private Button btnAddEvent;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist);

        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnBack = findViewById(R.id.btn_back);
        this.btnHist = findViewById(R.id.btn_hist);
        this.btnAddEvent = findViewById(R.id.btn_addevent2);

        this.btnBack.setOnClickListener(onClicklBack());
        this.btnHist.setOnClickListener(onClicklHist());
        this.btnAddEvent.setOnClickListener(onClicklAddEvent());
    }

    private View.OnClickListener onClicklAddEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistActivity.this, AddeventActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClicklHist() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistActivity.this, SchedActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClicklBack() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistActivity.this, HomeActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

}
