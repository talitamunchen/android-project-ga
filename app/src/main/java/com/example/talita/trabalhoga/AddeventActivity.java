package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddeventActivity extends AppCompatActivity {

    private LinearLayout btnBack;
    private Button btnAddEvent;
    private String userName;
    private TextView txNameEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);

        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnBack = findViewById(R.id.btn_back);
        this.btnAddEvent = findViewById(R.id.btn_addevent);
        this.txNameEvent = findViewById(R.id.input_eventname);

        this.btnBack.setOnClickListener(onClicklBack());
        this.btnAddEvent.setOnClickListener(onClicklAddEvent());
    }

    private View.OnClickListener onClicklAddEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txNameEvent.getText().toString().trim().length() == 0){
                    Toast.makeText(AddeventActivity.this, "Nome inválido!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(AddeventActivity.this, HistActivity.class);
                    Bundle params = new Bundle();
                    params.putString("name", userName);
                    intent.putExtras(params);
                    Toast.makeText(AddeventActivity.this, "Evento adicionado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }

            }
        };
    }

    private View.OnClickListener onClicklBack() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddeventActivity.this, HistActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

}
