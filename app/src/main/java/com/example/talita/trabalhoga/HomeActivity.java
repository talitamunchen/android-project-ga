package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Talita on 21/04/2018.
 */

public class HomeActivity extends AppCompatActivity {

    private ImageView btnLogout;
    private LinearLayout petOne;
    private LinearLayout petTwo;
    private Button btnAddPet;
    private String userName;

    static final String TAG = HomeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.v(TAG, "Passou no OnCreate");
        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnLogout = findViewById(R.id.btn_logout);
        this.petOne = findViewById(R.id.petOne);
        this.petTwo = findViewById(R.id.petTwo);
        this.btnAddPet = findViewById(R.id.btn_addpet);

        this.btnLogout.setOnClickListener(onClickLogout());
        this.petOne.setOnClickListener(onClickPetOne());
        this.petTwo.setOnClickListener(onClickPetTwo());
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
                Log.v(TAG, "Clicou em adicionar pet");
            }
        };
    }

    private View.OnClickListener onClickPetOne() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HistActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
                Log.v(TAG, "Clicou em no pet um");
            }
        };
    }

    private View.OnClickListener onClickPetTwo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HistActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
                Log.v(TAG, "Clicou no pet dois");
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
            Log.v(TAG, "Clicou em sair");
            }
        };
    }

}
