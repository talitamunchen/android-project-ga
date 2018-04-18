package com.example.talita.trabalhoga;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(onClickLogin());

        View singup = findViewById(R.id.link_signup);
        singup.setOnClickListener(onClickSingup());

    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HistActivity.class);
                Bundle params = new Bundle();
                params.putString("nome", "nome");
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickSingup() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SingupActivity.class);
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