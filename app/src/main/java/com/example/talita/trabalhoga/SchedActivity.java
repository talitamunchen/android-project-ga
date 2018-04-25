package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SchedActivity extends AppCompatActivity {

    private ImageView btnBack;
    private String userName;

    static final String TAG = SchedActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sched);
        Log.v(TAG, "Passou no OnCreate");

        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnBack = findViewById(R.id.btn_back);

        this.btnBack.setOnClickListener(onClicklBack());
    }

    private View.OnClickListener onClicklBack() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchedActivity.this, HistActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
                Log.v(TAG, "Clicou em voltar");
            }
        };
    }

}
