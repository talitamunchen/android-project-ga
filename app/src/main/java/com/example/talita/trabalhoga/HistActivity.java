package com.example.talita.trabalhoga;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HistActivity extends AppCompatActivity {

    private ImageView btnBack;
    private Button btnAddEvent;
    private String userName;
    private TextView hist;

    static final String TAG = HistActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist);
        Log.v(TAG, "Passou no onCreate");

        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnBack = findViewById(R.id.btn_back);
        this.btnAddEvent = findViewById(R.id.btn_addevent2);

        this.hist = findViewById(R.id.hist);
        hist.setPaintFlags(hist.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        this.btnBack.setOnClickListener(onClicklBack());
        this.btnAddEvent.setOnClickListener(onClicklAddEvent());
        this.hist.setOnClickListener(onClicklHist());
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
                Log.v(TAG, "Clicou em adicionar evento");
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
                Log.v(TAG, "Clicou no histórico");
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
                Log.v(TAG, "Clicou em voltar");
            }
        };
    }

}
