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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtEmail,edtPassword;
    private Button btnSigin, btnSigUp,btnFogotPass;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inite();
        clickButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    // xu ly su kien
    private void clickButton() {
        // reset password
        btnFogotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFogot = new Intent(RegisterActivity.this,ForgotPasswordActivity.class);
                startActivity(intentFogot);
            }
        });

        // Login
        btnSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Sigup
        btnSigUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                //check validate
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6){
                    Toast.makeText(getApplicationContext(),"Password too short, enter minimum 6 characters!",Toast.LENGTH_SHORT).show();
                    return;
                }
                //hien progetbar
                progressBar.setVisibility(View.VISIBLE);
                //creat user
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this,"Creat user complete" + task.isSuccessful(),Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                //thong bao dang nhap
                                if (!task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this,"Authentication failed."+task.getException(),Toast.LENGTH_SHORT).show();
                                }else {
                                    Intent intentMain = new Intent(RegisterActivity.this,MainActivity.class);
                                    startActivity(intentMain);
                                    finish();
                                }
                            }
                        });
            }
        });

    }

    //anh xa
    private void inite() {
        edtEmail = findViewById(R.id.edt_sigup_mail);
        edtPassword = findViewById(R.id.edt_sigup_password);
        btnSigin = findViewById(R.id.btn_login);
        btnSigUp = findViewById(R.id.btn_sigup);
        btnFogotPass = findViewById(R.id.btn_reset_password);
        progressBar = findViewById(R.id.progressBar);
        auth = FirebaseAuth.getInstance();
    }


}
