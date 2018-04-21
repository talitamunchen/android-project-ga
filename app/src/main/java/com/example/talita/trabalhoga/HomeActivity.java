package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Talita on 21/04/2018.
 */

public class HomeActivity extends AppCompatActivity {

    private LinearLayout btnLogout;
    private LinearLayout petOne;
    private LinearLayout petTwo;
    private Button btnAddPet;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnLogout = findViewById(R.id.btn_logout);
        this.petOne = findViewById(R.id.petOne);
        this.petTwo = findViewById(R.id.petTwo);
        this.btnAddPet = findViewById(R.id.btn_addpet);

        this.btnLogout.setOnClickListener(onClickLogout());
        this.petOne.setOnClickListener(onClickPet());
        this.petTwo.setOnClickListener(onClickPet());
        this.btnAddPet.setOnClickListener(onClicklAddPet());
    }

    private View.OnClickListener onClicklAddPet() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddpetActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickPet() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HistActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickLogout() {
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
