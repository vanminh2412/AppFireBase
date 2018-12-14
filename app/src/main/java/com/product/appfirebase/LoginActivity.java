package com.product.appfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail,edtPassword;
    private Button btnLogin,btnSigup,btnFogotPass;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get auth
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);

        initview();
        onclickButton();

    }
    //xu ly su kien
    private void onclickButton() {
        auth = FirebaseAuth.getInstance();
        //Sigup
        btnSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        //reset password
        btnFogotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });
        //login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                final String password = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT);
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //auth sigin
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()){
                            //check pass
                            if (password.length()<6){
                                edtPassword.setError(getString(R.string.minimum_password));
                            }else {
                                Toast.makeText(LoginActivity.this, getString(R.string.auth_fail),Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });
    }

    //anh xa
    private void initview() {edtEmail = findViewById(R.id.edt_mail);
        edtPassword = findViewById(R.id.edt_password);
        btnFogotPass = findViewById(R.id.btn_reset_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSigup = findViewById(R.id.btn_sigup);
        progressBar = findViewById(R.id.progressBar);

    }
}
