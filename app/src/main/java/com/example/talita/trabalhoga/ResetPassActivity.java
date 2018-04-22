package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassActivity extends AppCompatActivity {

    private TextView txUserEmail;
    private TextView txUserPass;
    private TextView txlinkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        Button resetPass = findViewById(R.id.btn_reset);
        resetPass.setOnClickListener(onClickResetPass());

        this.txUserEmail = findViewById(R.id.input_email);
        this.txUserPass = findViewById(R.id.input_password);

        this.txlinkLogin = findViewById(R.id.link_login);
        txlinkLogin.setOnClickListener(onClickReturnLogin());


    }

    private View.OnClickListener onClickReturnLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(ResetPassActivity.this, LoginActivity.class);
            startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickResetPass() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txUserEmail.getText().toString().trim().length() == 0){
                    Toast.makeText(ResetPassActivity.this, "Nome inválido!", Toast.LENGTH_LONG).show();
                }else if(txUserPass.getText().toString().trim().length() == 0){
                    Toast.makeText(ResetPassActivity.this, "Senha inválido!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(ResetPassActivity.this, LoginActivity.class);
                    Toast.makeText(ResetPassActivity.this, "E-mail enviado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        };
    }

}
