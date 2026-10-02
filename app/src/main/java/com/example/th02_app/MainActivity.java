package com.example.th02_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtTaiKhoan, edtMatKhau;
    Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(v -> {

            String taiKhoan = edtTaiKhoan.getText().toString().trim();
            String matKhau = edtMatKhau.getText().toString().trim();

            if (taiKhoan.isEmpty()) {
                Toast.makeText(this,
                        "Vui lòng nhập tài khoản",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (matKhau.isEmpty()) {
                Toast.makeText(this,
                        "Vui lòng nhập mật khẩu",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (taiKhoan.equals("admin") && matKhau.equals("123456")) {

                Intent intent = new Intent(
                        MainActivity.this,
                        HomeActivity.class
                );

                startActivity(intent);

            } else {

                Toast.makeText(this,
                        "Tài khoản hoặc mật khẩu không đúng",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}