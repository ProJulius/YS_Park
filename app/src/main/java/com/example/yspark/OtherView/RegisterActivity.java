package com.example.yspark.OtherView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yspark.R;
import com.example.yspark.View.MainActivity;

public class RegisterActivity extends AppCompatActivity {
    Button btnBack, btnRegister;
    EditText edtEmail, edtPassword, edtConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);
        edtEmail = findViewById(R.id.inputEmail);
        edtPassword = findViewById(R.id.inputPassword);
        edtConfirm = findViewById(R.id.inputConfirm);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String confirm = edtConfirm.getText().toString().trim();

                if(email.length() != 0 && password.length() != 0 && confirm.length() != 0){
                    if(password.equals(confirm)){
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        Toast.makeText(RegisterActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else {
                        Toast.makeText(RegisterActivity.this, "Xác nhận mật khẩu sai!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if(email.length() == 0){
                        Toast.makeText(RegisterActivity.this, "Vui lòng nhập email!", Toast.LENGTH_SHORT).show();
                    }else if (password.length() == 0) {
                        Toast.makeText(RegisterActivity.this, "Vui lòng nhập mật khẩu!", Toast.LENGTH_SHORT).show();
                    }else if (confirm.length() == 0){
                        Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại mật khẩu!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
