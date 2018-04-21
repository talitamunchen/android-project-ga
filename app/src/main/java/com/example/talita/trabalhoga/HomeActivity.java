package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Talita on 21/04/2018.
 */

public class HomeActivity extends AppCompatActivity {

    private LinearLayout btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle args = getIntent().getExtras();
        String name = args.getString("name");

        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(onClicklLogout());
    }

    private View.OnClickListener onClicklLogout() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            Toast.makeText(HomeActivity.this, "Deslogado com sucesso!", Toast.LENGTH_LONG).show();
            startActivity(intent);
            }
        };
    }

}
