package com.example.savestatedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text_name)
    TextView textView;

    int a = 1;
    int b = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d("TAGG", "onCreate");
        textView.setText("hello");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAGG", "onSaveInstanceState");
        outState.putInt("abc", a);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        a = savedInstanceState.getInt("abc");
        textView.setText(String.valueOf(a));
    }

    @OnClick({R.id.btn_add})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                a++;
                b = b + 2;
                textView.setText(String.valueOf(a));
                break;
        }
    }
}