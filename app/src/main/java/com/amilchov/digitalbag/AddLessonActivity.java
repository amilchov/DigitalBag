package com.amilchov.digitalbag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddLessonActivity extends AppCompatActivity {

    @BindView(R.id.et_lesson_name)
    EditText editTextLessonName;

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);
        ButterKnife.bind(this);

        if(imageView.getVisibility() == View.GONE) {
            editTextLessonName.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.button})
    protected void onClick(View view) {
        String lessonName = editTextLessonName.getText().toString().trim();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("lessons", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("lesson", lessonName);
        editor.apply();
        startActivity(new Intent(this, LessonActivity.class));
    }
}
