package com.amilchov.digitalbag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LessonActivity extends AppCompatActivity {

    @BindView(R.id.cardView_lesson)
    CardView cardViewLesson;

    @BindView(R.id.tv_empty)
    TextView textViewEmpty;

    @BindView(R.id.tv_lesson)
    TextView textViewLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ButterKnife.bind(this);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("subject_grade", MODE_PRIVATE);
        String subject = pref.getString("subject", null);
        String grade = pref.getString("grade", null);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("lessons", MODE_PRIVATE);
        String lesson = preferences.getString("lesson", null);

        getSupportActionBar().setTitle(subject + " - " + grade + " клас");

        if(lesson == null) {
            cardViewLesson.setVisibility(View.GONE);
            textViewEmpty.setVisibility(View.VISIBLE);
        } else {
            cardViewLesson.setVisibility(View.VISIBLE);
            textViewEmpty.setVisibility(View.GONE);
            textViewLesson.setText(lesson);
        }
    }

    @OnClick({R.id.floatingActionButton})
    protected void onClick(View view) {
        if (view.getId() == R.id.floatingActionButton) {
            startActivity(new Intent(this, AddLessonActivity.class));
        }
    }
}
