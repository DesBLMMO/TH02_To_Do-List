package com.example.th02_app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {

    EditText edtTenCongViec;
    EditText edtGhiChu;

    Button btnChonThoiGian;
    Button btnLuu;

    String thoiGian = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        edtTenCongViec = findViewById(R.id.edtTenCongViec);
        edtGhiChu = findViewById(R.id.edtGhiChu);

        btnChonThoiGian = findViewById(R.id.btnChonThoiGian);
        btnLuu = findViewById(R.id.btnLuu);

        // Chọn thời gian
        btnChonThoiGian.setOnClickListener(v -> {
            chonThoiGian();
        });

        // Lưu công việc
        btnLuu.setOnClickListener(v -> {

            String tenCongViec =
                    edtTenCongViec.getText().toString().trim();

            String ghiChu =
                    edtGhiChu.getText().toString().trim();

            if (tenCongViec.isEmpty()) {

                Toast.makeText(
                        this,
                        "Vui lòng nhập tên công việc",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            if (thoiGian.isEmpty()) {

                Toast.makeText(
                        this,
                        "Vui lòng chọn thời gian hoàn thành",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Tạo Intent để gửi dữ liệu về HomeActivity
            Intent intent = new Intent();

            intent.putExtra(
                    "tenCongViec",
                    tenCongViec
            );

            intent.putExtra(
                    "thoiGian",
                    thoiGian
            );

            intent.putExtra(
                    "ghiChu",
                    ghiChu
            );

            // Trả dữ liệu về HomeActivity
            setResult(
                    RESULT_OK,
                    intent
            );

            finish();
        });
    }

    private void chonThoiGian() {

        Calendar calendar = Calendar.getInstance();

        int nam =
                calendar.get(Calendar.YEAR);

        int thang =
                calendar.get(Calendar.MONTH);

        int ngay =
                calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(
                        this,
                        (view, year, month, dayOfMonth) -> {

                            int gio =
                                    calendar.get(
                                            Calendar.HOUR_OF_DAY
                                    );

                            int phut =
                                    calendar.get(
                                            Calendar.MINUTE
                                    );

                            TimePickerDialog timePickerDialog =
                                    new TimePickerDialog(
                                            this,
                                            (timeView,
                                             hourOfDay,
                                             minute) -> {

                                                thoiGian =
                                                        dayOfMonth
                                                                + "/"
                                                                + (month + 1)
                                                                + "/"
                                                                + year
                                                                + " "
                                                                + hourOfDay
                                                                + ":"
                                                                + String.format(
                                                                "%02d",
                                                                minute
                                                        );

                                                btnChonThoiGian
                                                        .setText(
                                                                thoiGian
                                                        );
                                            },
                                            gio,
                                            phut,
                                            true
                                    );

                            timePickerDialog.show();

                        },
                        nam,
                        thang,
                        ngay
                );

        datePickerDialog.show();
    }
}