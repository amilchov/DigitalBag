package com.amilchov.digitalbag;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DocumentActivity extends AppCompatActivity {

    @BindView(R.id.image_lesson)
    ImageView imageViewLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        ButterKnife.bind(this);
    }
}
