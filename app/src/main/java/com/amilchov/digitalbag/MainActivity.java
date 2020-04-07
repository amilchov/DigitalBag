package com.amilchov.digitalbag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cardView_items)
    CardView cardViewItems;

    @BindView(R.id.tv_grade)
    TextView textViewGrade;

    @BindView(R.id.tv_subject)
    TextView textViewSubject;

    @BindView(R.id.tv_empty)
    TextView textViewEmpty;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bundle = new Bundle();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("subject_grade", MODE_PRIVATE);
        String subject = pref.getString("subject", null);
        String grade = pref.getString("grade", null);

        if(pref.getString("subject", null) == null) {
            cardViewItems.setVisibility(View.GONE);
            textViewEmpty.setVisibility(View.VISIBLE);
        } else {
            textViewSubject.setText(subject);
            textViewGrade.setText("Клас: " + grade);
            cardViewItems.setVisibility(View.VISIBLE);
            textViewEmpty.setVisibility(View.GONE);

            bundle.putString("subject", subject);
            bundle.putString("grade", grade);

        }
    }

    @OnClick({R.id.floatingActionButton, R.id.cardView_items})
    protected void onClick(View view) {
        if (view.getId() == R.id.floatingActionButton)
            startActivity(new Intent(getApplicationContext(), AddCustomActivity.class));
        else if(view.getId() == R.id.cardView_items) {
            Intent intent = new Intent(this, LessonActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences.Editor editor = getSharedPreferences("subject_grade", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();

        SharedPreferences.Editor editor_lessons = getSharedPreferences("lessons", Context.MODE_PRIVATE).edit();
        editor_lessons.clear();
        editor_lessons.apply();
    }
}
