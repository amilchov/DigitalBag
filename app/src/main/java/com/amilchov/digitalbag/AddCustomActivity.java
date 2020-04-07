package com.amilchov.digitalbag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCustomActivity extends AppCompatActivity {

    @BindView(R.id.et_subject)
    EditText editTextSubject;

    @BindView(R.id.et_grade)
    EditText editTextGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_submit})
    protected void onClick() {
        String subject = editTextSubject.getText().toString().trim();
        String grade = editTextGrade.getText().toString().trim();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("subject_grade", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("subject", subject);
        editor.putString("grade", grade);
        editor.apply();
        startActivity(new Intent(this, MainActivity.class));
    }
}
