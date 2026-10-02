package com.example.th02_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btnThemHanhDong;

    LinearLayout layoutCongViecHomNay;
    LinearLayout layoutCongViecSapToi;

    private static final int REQUEST_ADD_TASK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnThemHanhDong =
                findViewById(R.id.btnThemHanhDong);

        layoutCongViecHomNay =
                findViewById(R.id.layoutCongViecHomNay);

        layoutCongViecSapToi =
                findViewById(R.id.layoutCongViecSapToi);

        btnThemHanhDong.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    AddTaskActivity.class
            );

            startActivityForResult(
                    intent,
                    REQUEST_ADD_TASK
            );
        });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );

        if (requestCode == REQUEST_ADD_TASK
                && resultCode == RESULT_OK
                && data != null) {

            // Nhận đúng 3 dữ liệu
            String tenCongViec =
                    data.getStringExtra("tenCongViec");

            String thoiGian =
                    data.getStringExtra("thoiGian");

            String ghiChu =
                    data.getStringExtra("ghiChu");

            // Tạo công việc
            CheckBox checkBox =
                    new CheckBox(this);

            checkBox.setText(
                    tenCongViec
                            + "\nThời gian: "
                            + thoiGian
                            + "\nGhi chú: "
                            + ghiChu
            );

            checkBox.setTextSize(16);

            // Thêm vào danh sách
            layoutCongViecHomNay.addView(
                    checkBox
            );
        }
    }
}