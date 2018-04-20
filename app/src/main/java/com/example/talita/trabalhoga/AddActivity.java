package com.example.talita.trabalhoga;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");

        Button addevent = findViewById(R.id.btn_addevent);
        addevent.setOnClickListener(onClickAddevent());

        Button addpet = findViewById(R.id.btn_addpet);
        addpet.setOnClickListener(onClickAddpet());
    }

    private View.OnClickListener onClickAddevent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddeventActivity.class);
                Bundle params = new Bundle();
                params.putString("nome", "nome");
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickAddpet() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddpetActivity.class);
                Bundle params = new Bundle();
                params.putString("nome", "nome");
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private Context getContext() {
        return this;
    }

}

