package com.example.rxjavademo;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        changeActivity();
    }

    @SuppressLint("CheckResult")
    private void changeActivity() {
        Single.timer(5, TimeUnit.SECONDS).subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Long aLong) {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
