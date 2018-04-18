package com.example.talita.trabalhoga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SchedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sched);
        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");
    }

}
