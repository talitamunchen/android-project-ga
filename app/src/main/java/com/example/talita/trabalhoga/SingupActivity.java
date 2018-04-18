package com.example.talita.trabalhoga;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SingupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");

        View login = findViewById(R.id.link_login);
        login.setOnClickListener(onClickLogin());

    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
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
