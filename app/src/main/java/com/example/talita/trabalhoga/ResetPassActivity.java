package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassActivity extends AppCompatActivity {

    private TextView txUserEmail;
    private TextView txUserPass;
    private TextView txlinkLogin;

    static final String TAG = ResetPassActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        Log.v(TAG, "Passou no onCreate");

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
                Log.v(TAG, "Vai retornar para o login");
            }
        };
    }

    private View.OnClickListener onClickResetPass() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txUserEmail.getText().toString().trim().length() == 0){
                    Toast.makeText(ResetPassActivity.this, "Nome inválido!", Toast.LENGTH_LONG).show();
                    Log.v(TAG, "Não conseguiu resetar a senha: nome inválido");
                }else if(txUserPass.getText().toString().trim().length() == 0){
                    Toast.makeText(ResetPassActivity.this, "Senha inválida!", Toast.LENGTH_LONG).show();
                    Log.v(TAG, "Não conseguiu resetar a senha: senha inválida");
                }else{
                    Intent intent = new Intent(ResetPassActivity.this, LoginActivity.class);
                    Toast.makeText(ResetPassActivity.this, "E-mail enviado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    Log.v(TAG, "Conseguiu resetar a senha");
                }
            }
        };
    }

}
