package com.example.talita.trabalhoga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String SAMPLE_USER = "fulano";
    public static final String SAMPLE_PASS = "123";

    static final String TAG = LoginActivity.class.getName();

    private TextView txUserName;
    private TextView txUserPass;
    private TextView resetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TAG, "Passou no OnCreate");

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(onClickLogin());

        this.txUserName = findViewById(R.id.input_name);
        this.txUserPass = findViewById(R.id.input_password);

        this.resetPass = findViewById(R.id.link_reset_pass);
        resetPass.setOnClickListener(onClickResetPass());

    }

    private View.OnClickListener onClickResetPass() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetPassActivity.class);
                startActivity(intent);
                Log.v(TAG, "Clicou em resetar a senha");
            }
        };
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txUserName.getText().toString();
                String userPass = txUserPass.getText().toString();
                if (userName.equals(SAMPLE_USER) && userPass.equals(SAMPLE_PASS)){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    Bundle params = new Bundle();
                    params.putString("name", userName);
                    intent.putExtras(params);
                    startActivity(intent);
                    Log.v(TAG, "Passou onClickLogin: conseguiu logar");
                }else{
                    Log.v(TAG, "Não passou onClickLogin: usuário ou senha inválido");
                    Toast.makeText(LoginActivity.this, "Usuário ou senha inválido!", Toast.LENGTH_LONG).show();
                }
            }
        };
    }

}