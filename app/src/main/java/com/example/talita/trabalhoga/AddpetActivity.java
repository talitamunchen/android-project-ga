package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddpetActivity extends AppCompatActivity {

    private LinearLayout btnBack;
    private Button btnAddPet;
    private String userName;

    private TextView txNamePet;
    private TextView txAgePet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpet);
        Bundle args = getIntent().getExtras();
        userName = args.getString("name");

        this.btnBack = findViewById(R.id.btn_back);
        this.btnAddPet = findViewById(R.id.btn_addpet2);

        this.txNamePet = findViewById(R.id.input_petname);
        this.txAgePet = findViewById(R.id.input_petage);

        this.btnBack.setOnClickListener(onClicklBack());
        this.btnAddPet.setOnClickListener(onClicklAddPet());
    }

    private View.OnClickListener onClicklAddPet() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txNamePet.getText().toString().trim().length() == 0){
                    Toast.makeText(AddpetActivity.this, "Nome inválido!", Toast.LENGTH_LONG).show();
                }else if(txAgePet.getText().toString().trim().length() == 0){
                    Toast.makeText(AddpetActivity.this, "Idade inválido!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(AddpetActivity.this, HomeActivity.class);
                    Bundle params = new Bundle();
                    params.putString("name", userName);
                    intent.putExtras(params);
                    Toast.makeText(AddpetActivity.this, "Pet adicionado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        };
    }

    private View.OnClickListener onClicklBack() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddpetActivity.this, HomeActivity.class);
                Bundle params = new Bundle();
                params.putString("name", userName);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

}
